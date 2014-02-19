package hikaruna.javaRubyLikeApi;

public interface Proc<Ret, Arg> {
	public Ret exec(Arg arg);
}
