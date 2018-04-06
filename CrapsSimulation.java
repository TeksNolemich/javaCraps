import java.util.Scanner;
//Ishan Zaveri 79101206 
//Arthur Tharp 71223707
public class CrapsSimulation
{
	private CrapsGame new_game; 
	private CrapsMetricsMonitor new_metrics;
	private String user_name;
	private Integer user_balance;
	private Integer bet;
	private Integer win_streak;
	private Integer lose_streak;
	
	public CrapsSimulation(){
		//defaults the values for the class
		new_metrics = new CrapsMetricsMonitor();
		new_game = new CrapsGame(new_metrics); 
		user_name = "";
		user_balance = 0;
		bet = 0;
		win_streak = 0;
		lose_streak = 0;
	}
	public void start(){
		//runs craps simulation
		Scanner scan_name = new Scanner(System.in);
		System.out.print("Welcome to SimCraps! Enter your user name: ");
		user_name = scan_name.next();
		System.out.println("Hello " + user_name);
		Scanner scan_balance = new Scanner(System.in);
		System.out.print("Enter the amount of money you will bring to the table: ");
		user_balance = scan_balance.nextInt();
		get_bet();
		int original_bet = bet; 
		while(user_balance > 0){
			new_metrics.set_games_played(new_metrics.get_games_played()+1);
			if (user_balance > new_metrics.get_max_balance()){
				new_metrics.set_max_balance(user_balance);
				new_metrics.set_max_balance_game(new_metrics.get_games_played());
			}
			System.out.println(user_name + "'s balance: $" + user_balance );
			if (user_balance < bet){ 
				bet = user_balance; 
			}
			else if(user_balance >= original_bet){ 
				bet = original_bet; 
			}
			System.out.println(user_name + " bets $" + bet);
			boolean result = new_game.playGame(); 
			if(new_game.get_rolls() > new_metrics.get_max_rolls()){ 
				new_metrics.set_max_rolls(new_game.get_rolls());
			}
			if(result == true){
				user_balance += bet; 
				new_metrics.set_games_won(new_metrics.get_games_won()+1);
				check_win_streak();
			}
			else if(result == false){ 
				user_balance -= bet;
				new_metrics.set_games_lost(new_metrics.get_games_lost()+1);
				check_lose_streak();
				
			} 
			new_metrics = new_game.get_metrics(); 
		}
		new_metrics.printStatistics();
		ask_replay();
		
	}
	
	public void get_bet(){ 
		//asks user for their bet
		boolean check = false; 
		Scanner scan_bet = new Scanner(System.in);
		System.out.print("Enter bet amount between $1 and " + user_balance + ":");
		bet = scan_bet.nextInt(); 
		if (1 <= bet && bet <= user_balance){ 
			check = true; 	
		}
		while(check == false){
			Scanner invalid_scan = new Scanner(System.in);
			System.out.print("Invalid bet! Please enter a bet between $1 and " + user_balance + ":");
			bet = invalid_scan.nextInt();
			if (1 <= bet && bet <= user_balance){
				check = true;
			}
		}
	}
	public void check_win_streak(){
		//checks the users win streak
		lose_streak = 0;
		win_streak++;
		if(win_streak > new_metrics.get_max_win_str()){ 
			new_metrics.set_max_win_str(win_streak);
		}
	}
	public void check_lose_streak(){
		//checks the users lose streak
		win_streak = 0;
		lose_streak++;
		if(lose_streak > new_metrics.get_max_lose_str()){ 
			new_metrics.set_max_lose_str(lose_streak);
		}
	}
	
	public void ask_replay(){  
		//asks the user if they want to replay
		Scanner scan_replay = new Scanner(System.in); 
		System.out.print("Replay? Enter 'y' or 'n': "); 
		String replay = scan_replay.nextLine(); 
		replay = replay.toUpperCase();
		Boolean check_y = replay.equals("Y"); 
		Boolean check_n = replay.equals("N");
		while(check_y == false && check_n == false){
			Scanner scan_invalid = new Scanner(System.in); 
			System.out.print("Try again? Enter 'y' or 'n': "); 
			replay = scan_invalid.next(); 
			replay = replay.toUpperCase();	
			check_y = replay.equals("Y"); 
			check_n = replay.equals("N");
		} 
		if(replay.equals("Y")){ 
			new_metrics.reset();
			new_game = new CrapsGame(new_metrics);
			user_name = "";
			user_balance = 0;
			bet = 0;
			win_streak = 0;
			lose_streak = 0;
			start();
		}
	}
}