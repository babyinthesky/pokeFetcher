package pokeFetcher;

import java.util.ArrayList;

public class OrderListHandler {

	private ArrayList<Integer> mOrderList;
	OrderListHandler() {
	      mOrderList = new ArrayList<Integer>();
	}
	
	public int insertInOrder(int num) {
		int length = mOrderList.size();
		if((length<10)||(length==10&&num>mOrderList.get(9))) {		
			if((length==10)&&(num>mOrderList.get(9))) {
					mOrderList.remove(9);
					length = 9;
			}
			for(int i=0;i<length;i++) {
				int curItem = mOrderList.get(i);
				if(num>=curItem) {
					mOrderList.add(i,num);
					return i;
				}
			}

			mOrderList.add(num);
			return mOrderList.size()-1;
		}
		return -1;
	}
}
