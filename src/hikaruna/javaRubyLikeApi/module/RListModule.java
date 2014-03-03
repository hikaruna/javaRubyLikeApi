package hikaruna.javaRubyLikeApi.module;

import hikaruna.javaRubyLikeApi.Proc;
import hikaruna.javaRubyLikeApi.RList;

import java.util.Collections;
import java.util.Comparator;
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

	public static <E> RList<E> sort(List<E> self) {
		return RListModule.sort(self, new Comparator<E>(){

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) o1).compareTo(o2);
			}
		});
	}

	public static <E> RList<E> sort(List<E> self, Comparator<E> comparator) {
		RList<E> ret = new RList<E>(self);
		Collections.sort(ret, comparator);
		return ret;
	}

	public static <T> RList<T> sortBy(List<T> self) {
		return RListModule.sort(self);
	}

	public static <E> RList<E> sortBy(List<E> self, final Proc<?, E> proc) {
		return RListModule.sort(self, new Comparator<E>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) proc.exec(o1)).compareTo((E) proc.exec(o2));
			}
		});
	}
}
