package lanqiao.entity;

public class Page {
	
	//页面大小
	private int pageSize;
	//页号
	private int currentPage;
	//总页数
	private int totlePage;
	//总记录数
	private int totleCount;
	//
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage=currentPage;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage() {
		this.totlePage=totleCount%pageSize==0?totleCount/pageSize:totleCount/pageSize+1;
	}
	public int getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}
}
