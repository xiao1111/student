package util.test.db;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ��ҳ�࣬���ڻ�ȡ��ҳ
 * ������˵����
 * 1���������ԣ�isReverse Boolean���ͣ����ڿ����Ƿ�ת��¼
 * 2��page�������Ӳ�����key String���ͣ�����ָ������session�еļ��ϵ�������
 * 3���Ľ��˷�ҳ�㷨
 * ��bug�޸�˵����
 * 1�����������ò�����Ч������
 * 2�������˼�¼˳���쳣������
 * 3���������޷���footer���������Ӳ�ѯ�ַ���������
 * 
 */
public class PageService {	
	private int pageId = 1;// ��ʾ��ǰ����ķ�ҳ��	
	private int pageSize = Integer.MAX_VALUE; // ÿҳ��ʾ�ļ�¼��
	private int rows; // ��¼����
	private int total; // �ܹ���ҳ��	
	private boolean isReverse = false;
	public int getPageId() {
		return pageId;
	}
    public void setPageId(int pageId) {
		if (pageId <= 0) {
			pageId = 1;
		}
		this.pageId = pageId;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setRows(List list) {
		this.rows = list.size();
	}
	public int getRows() {
		return rows;
	}		
	public boolean isReverse() {
		return isReverse;
	}
	public void setReverse(boolean isReverse) {
		this.isReverse = isReverse;
	}
	public void setTotal(List list) {// �÷���������ã��ܹ���ҳ��
		total = list.size() / pageSize;// �����������ó�pageSize������
		int e = list.size() % pageSize;// ����������������������
		if (e != 0) {// ���������Ϊ�㣬��total��һ
			this.total = this.total + 1;
		}
		//total��ʾ��ҳ��
		//total = (this.total%pageSize==0?this.total/pageSize:this.total/pageSize + 1);
		
	}
	public int getTotal() {
		return total;
	}
	/**
	 * ȡ�õ�ǰҳ������Ӧ�ļ�¼
	 * @param page_Id <code>String</code>���� ҳ��
	 * @param pageSize ÿҳ�Ĵ�С����ʾ����Ŀ����Ŀ��
	 * @param alllist ���еļ�¼�ļ���
	 * @return Ӧ����ҳ���ж�ȡ����Ŀ�ļ���
	 */
	public List getPage(String page_Id,int pageSize,List allList){
		if(null == page_Id){
			page_Id = "1";
		}
		//���������ҳ��
		setPageId(Integer.parseInt(page_Id));
		//���÷�ҳ�ļ�¼��
		setPageSize(pageSize);
		//���ü�¼����
		setRows(allList);
		//�����ܹ���ҳ��
		setTotal(allList);
		int start = 0;
		int end = 0;
		ArrayList tempList  = new ArrayList();
		if(this.isReverse)
		{
			for(int i = allList.size() ; i>0; i--)
			{
				tempList.add(allList.get(i-1));
			}
		}
		else
		{
			tempList = (ArrayList) allList;
		}
		List res = new ArrayList();
		int countAll = allList.size();
		
		if(total<=1){//������ҳ��С�ڵ���һ��Ҳ����˵��ʵֻ��һҳ
			start = 0 ;
			end = countAll;
		} else if(pageId < total){ //��������ҳ��С�����ҳ��
			start = (pageId - 1) * pageSize;
			end = pageId * pageSize;
		} else if(pageId >= total){ //��������ҳ����ڵ������ҳ��
			start = (pageId - 1) * pageSize;
			end = countAll;
		}		
		res = tempList.subList(start, end);
		return res;
	}
		
	/**
	 * ��ʾҳ�뵼��
	 * @param path ����ҳ�������URL����Ҫ����ѯ�ַ���
	 * @param action ��ѽ������URL�������ӵĲ�ѯ�ַ������ԡ�&����ͷ(�ο�����<code>"&command=key"</code>)������޲���������
	 * @return
	 */
	public String getPageFooter(String path,String action){ 
		if(action==null)
		{
			action = "";
		}
		String str = "";
		int to_tal =total-(total-1); 
		int next, prev;
		prev = pageId - 1;
		next = pageId + 1;
		if(pageId>1){
			str += "<a href="+path+"&pageId=" + to_tal + action +">��ҳ</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId>1){
			str += "<a href="+path+"&pageId=" + prev + action +">&lt;&lt;��һҳ</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId<total){
			str += "<a href="+path+"&pageId=" + next + action+">��һҳ&gt;&gt;</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId<total){
			str += "<a href="+path+"&pageId=" + total + action+">βҳ</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		str += "��ǰ��<font color ='blue'>"+pageId+"</font>ҳ&nbsp;&nbsp��<font color ='blue'>"+total+"</font>ҳ&nbsp;&nbsp;��<font color ='blue'>"+rows+"</font>��";
		return str;
	}
	/**
	 * ��һ��ҳ����Ҫ��ʾ����Ŀ�ļ���д��session������
	 * @param request 
	 * @param response
	 * @param list ȫ������Ŀ�ļ���
	 * @param pagemethod ��ѯ�ַ������벻Ҫ�ԡ�?����ͷ���ο�����:<code>"command=key"</code>
	 * @param key ��ǰҳ����Ŀ�Ķ����������
	 */
	public void page(HttpServletRequest request, HttpServletResponse response,List list,String pagemethod,String key) 
	{
		
		//ȡ�õ�ǰ��ҳ��
		String pageId = request.getParameter("pageId");
		String footer = "";
		//ÿҳ��ʾ�ļ�¼
		List pageList = this.getPage(pageId, pageSize, list);	
		footer = this.getPageFooter(request.getRequestURI()+"?"+pagemethod,"");
		HttpSession session = request.getSession();
		session.setAttribute(key,pageList);
		session.setAttribute("footer", footer);
	}
}
