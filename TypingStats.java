//-----------------------------------------------------------------------------------------------Interface TypingStats
                                                                                        
public abstract interface TypingStats {
    public double time(double start, double stop);
    public double accuracy(String test, String input);
    public int wpm(int rawwpm, double accuracy);
    public int rawwpm(int chars, double time);
}

//-----------------------------------------------------------------------------------------------Interface TypingStats
