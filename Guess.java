
public class Guess {
	private char[] Guess = {'*','*','*','*','*'};;
	private char[] Target = new char[5];
	private String GuessClone;
	private String TargetClone;
	private char[] TargetChecker = new char[5];
	public Guess(String guess, String target) {
		GuessClone = guess.trim();
		TargetClone = target.trim();
		for (int i = 0; i < GuessClone.length(); i++) {
            Guess[i] = GuessClone.toLowerCase().charAt(i);
        }
		for (int i = 0; i < TargetClone.length(); i++) {
            Target[i] = TargetClone.toLowerCase().charAt(i);
        }
		for (int i = 0; i < TargetClone.length(); i++) {
            TargetChecker[i] = TargetClone.toUpperCase().charAt(i);
        }
	}
	public char[] getTarget() {
		return Target;
	}
	public char[] getGuess() {
		return Guess;
	}
	public String GuessClone() {
		return Guess.toString();
	}
	public char[] targetChecker() {
		return TargetChecker;
	}
	public boolean matches() {
	
		for (int i = 0; i < Guess.length; i++)
		{
			if (Guess[i] != targetChecker()[i])
			{
				return false;
			}
		}
		return true;
	}
	public char[] checkChars() {
		
		for(int i = 0; i < Guess.length; i++) {
			boolean equal = false;
			for (int j = 0; j < Target.length; j++) {
				if (Guess[i] == Target[j]) {
					equal = true;
					if (i == j) {
						Guess[i] = Character.toUpperCase(Guess[i]);
					} else {
						Guess[i] = Character.toLowerCase(Guess[i]);
					}
				}
				
			}
			if (equal != true) {
				Guess[i] = '*';
			}
		}
		return Guess;
		
	}
	
		
}

