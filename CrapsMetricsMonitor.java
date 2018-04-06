//Ishan Zaveri 79101206 
//Arthur Tharp 71223707
public class CrapsMetricsMonitor
{
	private int games_played;
	private int games_won;
	private int games_lost;
	private int max_rolls;
	private int natural_roll;
	private int craps_roll;
	private int max_winning_str;
	private int max_losing_str;
	private int max_balance;
	private int max_bal_game;
	
	public CrapsMetricsMonitor(){ 
		games_played = 0;
		games_won = 0;
		games_lost = 0;
		max_rolls = 0;
		natural_roll = 0;
		craps_roll = 0;
		max_winning_str = 0;
		max_losing_str = 0;
		max_balance = 0;
		max_bal_game = 0;
	}
	public int get_games_played(){
		//returns total amount of games played
		return games_played; 
	}
	
	public int get_games_won(){ 
		//returns the total games won
		return games_won;
	}
	
	public int get_games_lost(){ 
		//returns the total games lost
		return games_lost; 
	}
	
	public int get_max_rolls(){ 
		//returns the maximum rolls in a single games
		return max_rolls;
	}
	
	public int get_natural_roll(){ 
		// returns win on first roll
		return natural_roll;
	}	
	
	public int get_craps_roll(){ 
		//returns loss on first roll
		return craps_roll;
	}
	
	public int get_max_win_str(){ 
		//returns maximum consecutive winning streak of player
		return max_winning_str;
	}
	
	public int get_max_lose_str(){ 
		//returns maximum consecutive losing streak of player
		return max_losing_str;
	}
	
	public int get_max_balance(){ 
		//returns the max balance during the entire simulation
		return max_balance;
	}
	
	public int get_max_balance_game(){ 
		//returns the maximum balance during a single game
		return max_bal_game;
	}
	
	public void set_games_played(int games_played){
		//sets the amount of games played
		this.games_played = games_played;
	}
	
	public void set_games_won(int games_won){ 
		//sets the games won
		this.games_won = games_won;
	}
	
	public void set_games_lost(int games_lost){ 
		//sets the games lost
		this.games_lost = games_lost;
	}
	
	public void set_max_rolls(int max_rolls){ 
		//sets maximum rolls thrown in a single game
		this.max_rolls = max_rolls;
	}
	
	public void set_natural_roll(int natural_roll){
		//sets the natural (win on first roll)
		this.natural_roll = natural_roll;
	}	
	
	public void set_craps_roll(int craps_roll){ 
		//sets the craps roll (loss on the first roll)
		this.craps_roll = craps_roll;
	}
	
	public void set_max_win_str(int max_winning_str){ 
		//sets the max consecutive amount of wins 
		this.max_winning_str = max_winning_str;
	}
	
	public void set_max_lose_str(int max_losing_str){ 
		//sets the max consecutive amount of losses
		this.max_losing_str = max_losing_str;
	}
	
	public void set_max_balance(int max_balance){
		//sets the maximum balance over entire simulation
		this.max_balance = max_balance;
	}
	
	public void set_max_balance_game(int max_bal_game){ 
		//sets the maximum balance in a single game
		this.max_bal_game = max_bal_game;
	}
	
	public void printStatistics(){
		//prints the statistics from the entire simulation
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games Played: " + games_played);
		System.out.println("Games Won: " + games_won);
		System.out.println("Games Lost: " + games_lost);
		System.out.println("Maximum Rolls in a Single Game: " + max_rolls);
		System.out.println("Natural Count: " + natural_roll);
		System.out.println("Craps Count: " + craps_roll);
		System.out.println("Maximum Winning Streak: " + max_winning_str);
		System.out.println("Maximum Losing Streak: " + max_losing_str);
		System.out.println("Maximum Balance: " + max_balance + " During Game " + max_bal_game);
	}
	public void reset(){
		//resets statistics from simulation
		games_played = 0;
		games_won = 0;
		games_lost = 0;
		max_rolls = 0;
		natural_roll = 0;
		craps_roll = 0;
		max_winning_str = 0;
		max_losing_str = 0;
		max_balance = 0;
		max_bal_game = 0;
	}
	
}
