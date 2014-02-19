package hikaruna.javaRubyLikeApi.module;

import hikaruna.javaRubyLikeApi.Proc;
import hikaruna.javaRubyLikeApi.RList;

import java.util.List;

public class RListModule {

	public static <E> RList<E> select(List<E> self, Proc<Boolean, E> proc) {
		RList<E> ret = new RList<E>();
		for(E item : self) {
			if(proc.exec(item)) {
				ret.add(item);
			}
		}
		return ret;
	}
}
