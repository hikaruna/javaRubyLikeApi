package hikaruna.javaRubyLikeApi.module;

import hikaruna.javaRubyLikeApi.Proc;
import hikaruna.javaRubyLikeApi.RList;

public class RListModule {

	public static <E> RList<E> select(RList<E> self, Proc<Boolean, E> proc) {
		RList<E> ret = new RList<E>();
		for(E item : self) {
			if(proc.exec(item)) {
				ret.add(item);
			}
		}
		return ret;
	}
}
