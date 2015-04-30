package util.test.db;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 分页类，用于获取分页
 * 【更新说明】
 * 1，增加属性：isReverse Boolean类型，用于控制是否反转记录
 * 2，page方法增加参数：key String类型，用于指定存入session中的集合的属性名
 * 3，改进了分页算法
 * 【bug修改说明】
 * 1，修正了设置参数无效的问题
 * 2，修正了记录顺序异常的问题
 * 3，修正了无法在footer链接中增加查询字符串的问题
 * 
 */
public class PageService {	
	private int pageId = 1;// 表示当前请求的分页号	
	private int pageSize = Integer.MAX_VALUE; // 每页显示的记录数
	private int rows; // 记录总数
	private int total; // 总共的页数	
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
	public void setTotal(List list) {// 该方法用来求得，总共的页数
		total = list.size() / pageSize;// 该语句用来求得除pageSize的整数
		int e = list.size() % pageSize;// 该语句用来求得相除后的余数
		if (e != 0) {// 如果余数不为零，则total加一
			this.total = this.total + 1;
		}
		//total表示总页数
		//total = (this.total%pageSize==0?this.total/pageSize:this.total/pageSize + 1);
		
	}
	public int getTotal() {
		return total;
	}
	/**
	 * 取得当前页码所对应的记录
	 * @param page_Id <code>String</code>类型 页码
	 * @param pageSize 每页的大小（显示的条目的数目）
	 * @param alllist 所有的记录的集合
	 * @return 应该在页面中读取的条目的集合
	 */
	public List getPage(String page_Id,int pageSize,List allList){
		if(null == page_Id){
			page_Id = "1";
		}
		//设置请求分页号
		setPageId(Integer.parseInt(page_Id));
		//设置分页的记录数
		setPageSize(pageSize);
		//设置记录总数
		setRows(allList);
		//设置总共的页数
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
		
		if(total<=1){//如果最大页数小于等于一，也就是说其实只有一页
			start = 0 ;
			end = countAll;
		} else if(pageId < total){ //如果请求的页码小于最大页数
			start = (pageId - 1) * pageSize;
			end = pageId * pageSize;
		} else if(pageId >= total){ //如果请求的页码大于等于最大页数
			start = (pageId - 1) * pageSize;
			end = countAll;
		}		
		res = tempList.subList(start, end);
		return res;
	}
		
	/**
	 * 显示页码导航
	 * @param path 请求页面的完整URL，不要带查询字符串
	 * @param action 需呀在请求URL额外增加的查询字符串，以“&”开头(参考范例<code>"&command=key"</code>)，如果无参数请留空
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
			str += "<a href="+path+"&pageId=" + to_tal + action +">首页</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId>1){
			str += "<a href="+path+"&pageId=" + prev + action +">&lt;&lt;上一页</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId<total){
			str += "<a href="+path+"&pageId=" + next + action+">下一页&gt;&gt;</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		if(pageId<total){
			str += "<a href="+path+"&pageId=" + total + action+">尾页</a>&nbsp;&nbsp;";
		}else{
			str += "";
		}
		str += "当前第<font color ='blue'>"+pageId+"</font>页&nbsp;&nbsp共<font color ='blue'>"+total+"</font>页&nbsp;&nbsp;总<font color ='blue'>"+rows+"</font>条";
		return str;
	}
	/**
	 * 将一个页面需要显示的条目的集合写入session对象中
	 * @param request 
	 * @param response
	 * @param list 全部的条目的集合
	 * @param pagemethod 查询字符串，请不要以“?”开头，参考范例:<code>"command=key"</code>
	 * @param key 当前页面条目的对象的属性名
	 */
	public void page(HttpServletRequest request, HttpServletResponse response,List list,String pagemethod,String key) 
	{
		
		//取得当前的页码
		String pageId = request.getParameter("pageId");
		String footer = "";
		//每页显示的记录
		List pageList = this.getPage(pageId, pageSize, list);	
		footer = this.getPageFooter(request.getRequestURI()+"?"+pagemethod,"");
		HttpSession session = request.getSession();
		session.setAttribute(key,pageList);
		session.setAttribute("footer", footer);
	}
}
