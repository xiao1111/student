function positionNavigation(){
	var nav = document.getElementById("navigation");
	var y;
	nav.style.width = window.screen.width + "px";
	y = window.pageYOffset;
	nav.style.top = y + "px";
	nav.style.posTop = y;
}
	window.onload = positionNavigation;
	window.onscroll = positionNavigation;

