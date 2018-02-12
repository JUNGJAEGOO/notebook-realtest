package back2590;

import java.util.*;

public class Main {
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		arr = new int[7];
		int sum = 0;
		
		for ( int i = 1 ; i<= 6 ; i++) {
			arr[i] = in.nextInt();
			if ( i == 6) {
				sum += arr[i];
			}
		}
		
		while ( arr[5] >= 1) {
			
			arr[5]--;
			for (int i = 1 ; i <= 11 ; i++) {
				if ( arr[1] >= 1) {
					arr[1]--;
				}
			}
			sum++;
		}
		
		while ( arr[4] >= 1) {
			
			arr[4]--;
			if ( arr[2] >= 5) {
				arr[2]-= 5;
			}else if ( arr[2] == 4) {
				arr[2]-= 4;
				for (int i = 1 ; i <= 4 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 3) {
				arr[2] -= 3;
				for (int i = 1 ; i <= 8 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 2) {
				arr[2] -= 2;
				for (int i = 1 ; i <= 12 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 1) {
				arr[2] --;
				for (int i = 1 ; i <= 16 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 0) {
				for (int i = 1 ; i <= 20; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
				
			}

			sum++;
		}
		
		
		while ( arr[3] >= 1) {
			if ( arr[3] >= 4) {
				arr[3] -= 4;
			}else if ( arr[3] == 3) {
				arr[3] -= 3;
				if ( arr[2] >= 1) {
					arr[2] -= 1;
					for (int i = 1 ; i <= 5 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 0) {
					for (int i = 1 ; i <= 9 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}
			}else if ( arr[3] == 2) {
				arr[3] -= 2;
				if ( arr[2] >= 3) {
					arr[2] -= 3;
					for (int i = 1 ; i <= 6 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if  ( arr[2] == 2) {
					arr[2] -= 2;
					for (int i = 1 ; i <= 10 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 1) {
					arr[2]--;
					for (int i = 1 ; i <= 14 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}
				else if ( arr[2] == 0) {
					for (int i = 1 ; i <= 18 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}
				
			}else if ( arr[3] == 1) {
				arr[3] -= 1;
				if ( arr[2] >= 5) {
					arr[2]-=5;
					for (int i = 1 ; i <= 7 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 4) {
					arr[2] -=4 ;
					for (int i = 1 ; i <= 11 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 3) {
					arr[2] -= 3;
					for (int i = 1 ; i <= 15 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 2) {
					arr[2] -= 2;
					for (int i = 1 ; i <= 19 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 1) {
					arr[2] --;
					for (int i = 1 ; i <= 23 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}else if ( arr[2] == 0) {
					for (int i = 1 ; i <= 27 ; i++) {
						if ( arr[1] >= 1) {
							arr[1]--;
						}
					}
				}
			}
			sum++;
		}
		
		while ( arr[2] >= 1) {
			if ( arr[2] >= 9) {
				arr[2] -= 9;
			}else if ( arr[2] == 8) {
				arr[2] -= 8;
				for (int i = 1 ; i <= 4; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 7) {
				arr[2] -= 7;
				for (int i = 1 ; i <= 8 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 6) {
				arr[2] -= 6;
				for (int i = 1 ; i <= 12 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 5) {
				arr[2] -= 5;
				for (int i = 1 ; i <= 16 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 4) {
				arr[2] -= 4;
				for (int i = 1 ; i <= 20 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 3) {
				arr[2] -= 3;
				for (int i = 1 ; i <= 24 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 2) {
				arr[2] -= 2;
				for (int i = 1 ; i <= 28 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}else if ( arr[2] == 1) {
				arr[2] -= 1;
				for (int i = 1 ; i <= 32 ; i++) {
					if ( arr[1] >= 1) {
						arr[1]--;
					}
				}
			}
			sum++;
		}
		
		while ( arr[1] >= 1) {
			for (int i = 1 ; i <= 36 ; i++) {
				if ( arr[1] >= 1) {
					arr[1]--;
				}
			}
			sum++;
		}
		
		System.out.println(sum);
	}

}
