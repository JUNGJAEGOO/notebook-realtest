import java.io.*;

public class SerialDTO implements Serializable{
	static final long serailVersionUID = 1L;
	private String bookName;
	private int bookOrder;
	private boolean bestSeller;
	private long soldPerDay;
	private String bookType = "IT";

	public SerialDTO(String bookName,int bookOrder,boolean bestSeller,long soldPerDay) {
		this.bookName = bookName;
		this.bookOrder = bookOrder;
		this.bestSeller = bestSeller;
		this.soldPerDay = soldPerDay;
	}
	
	@Override
	public String toString() {
		return "SerialDTO [bookname="+bookName+ ", bookOrder=" + bookOrder + ", bestSeller="
				+ bestSeller + ", soldPerDay=" + soldPerDay +"]";
	}
	
}
