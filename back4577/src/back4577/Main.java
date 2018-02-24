package back4577;

import java.util.*;

public class Main {
	static int R,C;
	static char mat[][];
	static boolean visit[][];
	static ArrayList<node> targets;
	static char[] command;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = 1;
		while ( true) {
			
			String input[] = in.nextLine().split(" ");
			R = Integer.parseInt(input[0]);
			C = Integer.parseInt(input[1]);
			if ( R == 0 && C == 0) {
				break;
			}
			mat = new char[R][C];
			visit = new boolean[R][C];
			
			int X = -1 ,Y= -1;
			targets = new ArrayList<>();
			
			for (int i = 0 ; i < R; i++) {
				char tmp[] = in.nextLine().toCharArray();
				for (int j = 0 ; j < C ; j++) {
					mat[i][j] = tmp[j];
					if ( mat[i][j] == 'w' ) {
						X = i; Y = j;
					}else if ( mat[i][j] == 'W') {
						X = i; Y = j;
					}
					
					if ( mat[i][j] == 'B') {
						targets.add(new node(i,j));
					}
					if ( mat[i][j] == '+') {
						targets.add(new node(i,j));
					}
					if ( mat[i][j] == 'W') {
						targets.add(new node(i,j));
					}
				}
			}
			
			boolean pass = false;
			command = in.nextLine().toCharArray();
			for (int i = 0 ; i < command.length ; i++) {
				
				if ( command[i] == 'U') {
					if ( X-1 >= 0) {
						if ( mat[X-1][Y] == 'b' || mat[X-1][Y] == 'B') {

							if ( X-2 < 0 || mat[X-2][Y] == 'b' || mat[X-2][Y] == 'B' || mat[X-2][Y] == '#') {
								continue;
							}else {
								if ( mat[X-2][Y] == '.') {
									mat[X-2][Y] = 'b';
									if ( mat[X-1][Y] == 'b') {
										mat[X-1][Y] = 'w';
									}else if ( mat[X-1][Y] == 'B') {
										mat[X-1][Y] = 'W';
									}
									
									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									X = X - 1;
									
								}else if ( mat[X-2][Y] == '+') {
									mat[X-2][Y] = 'B';
									if ( mat[X-1][Y] == 'b') {
										mat[X-1][Y] = 'w';
									}else if ( mat[X-1][Y] == 'B') {
										mat[X-1][Y] = 'W';
									}

									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									X = X - 1;
								}
								
							}
						}else if ( mat[X-1][Y] == '+' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X-1][Y] = 'W';
							X = X - 1;
						}else if ( mat[X-1][Y] == '.' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X-1][Y] = 'w';
							X = X -1;
				
						}else if ( mat[X-1][Y] == '#') {
							continue;
						}
					}
				}else if ( command[i] == 'D') {
					if ( X+1 <  R) {
						if ( mat[X+1][Y] == 'b' || mat[X+1][Y] == 'B') {

							if ( X+2 >= R || mat[X+2][Y] == 'b' || mat[X+2][Y] == 'B' || mat[X+2][Y] == '#') {
								continue;
							}else {
								if ( mat[X+2][Y] == '.') {
									mat[X+2][Y] = 'b';
									if ( mat[X+1][Y] == 'b') {
										mat[X+1][Y] = 'w';
									}else if ( mat[X+1][Y] == 'B') {
										mat[X+1][Y] = 'W';
									}
									
									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									X = X +1;
									
								}else if ( mat[X+2][Y] == '+') {
									mat[X+2][Y] = 'B';
									if ( mat[X+1][Y] == 'b') {
										mat[X+1][Y] = 'w';
									}else if ( mat[X+1][Y] == 'B') {
										mat[X+1][Y] = 'W';
									}

									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									X = X +1;
								}
								
							}
						}else if ( mat[X+1][Y] == '+' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X+1][Y] = 'W';
							X = X +1;
						}else if ( mat[X+1][Y] == '.' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X+1][Y] = 'w';
							X = X +1;
				
						}else if ( mat[X+1][Y] == '#') {
							continue;
						}
					}
				}else if ( command[i] == 'L') {
					if ( Y-1 >= 0) {
						if ( mat[X][Y-1] == 'b' || mat[X][Y-1] == 'B') {

							if ( Y-2 < 0 || mat[X][Y-2] == 'b' || mat[X][Y-2] == 'B' || mat[X][Y-2] == '#') {
								continue;
							}else {
								if ( mat[X][Y-2] == '.') {
									mat[X][Y-2] = 'b';
									if ( mat[X][Y-1] == 'b') {
										mat[X][Y-1] = 'w';
									}else if ( mat[X][Y-1] == 'B') {
										mat[X][Y-1] = 'W';
									}
									
									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									Y = Y - 1;;
									
								}else if ( mat[X][Y-2] == '+') {
									mat[X][Y-2] = 'B';
									if ( mat[X][Y-1] == 'b') {
										mat[X][Y-1] = 'w';
									}else if ( mat[X][Y-1] == 'B') {
										mat[X][Y-1] = 'W';
									}

									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									Y = Y - 1;
								}
								
							}
						}else if ( mat[X][Y-1] == '+' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X][Y-1] = 'W';
							Y = Y - 1;
						}else if ( mat[X][Y-1] == '.' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X][Y-1] = 'w';
							Y = Y  -1;
				
						}else if ( mat[X][Y-1] == '#') {
							continue;
						}
					}
				}else if ( command[i] == 'R') {
					if ( Y+1 < C ) {
						if ( mat[X][Y+1] == 'b' || mat[X][Y+1] == 'B') {

							if ( Y+2 >= C || mat[X][Y+2] == 'b' || mat[X][Y+2] == 'B' || mat[X][Y+2] == '#') {
								continue;
							}else {
								
								if ( mat[X][Y+2] == '.') {
									mat[X][Y+2] = 'b';
									if ( mat[X][Y+1] == 'b') {
										mat[X][Y+1] = 'w';
									}else if ( mat[X][Y+1] == 'B') {
										mat[X][Y+1] = 'W';
									}
									
									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									Y = Y + 1;
									
								}else if ( mat[X][Y+2] == '+') {
									mat[X][Y+2] = 'B';
									if ( mat[X][Y+1] == 'b') {
										mat[X][Y+1] = 'w';
									}else if ( mat[X][Y+1] == 'B') {
										mat[X][Y+1] = 'W';
									}

									if ( mat[X][Y] == 'W') {
										mat[X][Y] = '+';
									}else if ( mat[X][Y] == 'w') {
										mat[X][Y] = '.';
									}
									
									Y = Y + 1;
								}
								
							}
						}else if ( mat[X][Y+1] == '+' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X][Y+1] = 'W';
							Y = Y + 1;
						}else if ( mat[X][Y+1] == '.' ) {
							if ( mat[X][Y] == 'W') {
								mat[X][Y] = '+';
							}else if ( mat[X][Y] == 'w') {
								mat[X][Y] = '.';
							}
							mat[X][Y+1] = 'w';
							Y = Y  + 1;
				
						}else if ( mat[X][Y+1] == '#') {
							continue;
						}
					}
				}

				int sum = 0;
				for (int s = 0 ; s < R ; s++) {
					for (int k = 0 ; k < C; k++) {
						if ( mat[s][k] == 'B') {
							sum++;
						}
					}
				}
				
				if ( sum == targets.size()) {
					pass = true;
					break;
				}
				
				/*for (int s = 0 ; s < R ; s++) {
					for (int k = 0 ; k < C; k++) {
						System.out.print(mat[s][k]);
					}System.out.println();
				}System.out.println();*/
				
			}
			
			if ( pass) {
				System.out.println("Game "+t+": complete");
			}else {
				System.out.println("Game "+t+": incomplete");
			}
			for (int i = 0 ; i < R ; i++) {
				for (int j = 0 ; j < C; j++) {
					System.out.print(mat[i][j]);
				}System.out.println();
			}
			
			t++;
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}
