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

	/**
	 * 最小の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E min(List<E> self) {
		return RListModule.min(self, new Comparator<E>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) o1).compareTo((E) o2);
			}
		});
	}

	/**
	 * 最大の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E max(List<E> self) {
		return RListModule.max(self, new Comparator<E>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) o1).compareTo((E) o2);
			}
		});
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最小の要素を返します.
	 */
	public static <E> E min(List<E> self, Comparator<E> comparator) {
		return RListModule.sort(self, comparator).get(0);
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最大の要素を返します.
	 */
	public static <E> E max(List<E> self, Comparator<E> comparator) {
		RList<E> ret = RListModule.sort(self, comparator);
		return ret.get(ret.size() - 1);
	}

	/**
	 * 最小の要素を返します.
	 * @see RListModule#min(List)
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E minBy(List<E> self) {
		return RListModule.min(self);
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最小であった値に対応する元の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E minBy(List<E> self, final Proc<Integer, E> proc) {
		return RListModule.min(self, new Comparator<E>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) proc.exec(o1)).compareTo((E) proc.exec(o2));
			}
		});
	}

	/**
	 * 最大の要素を返します.
	 * @see RListModule#max(List)
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E maxBy(List<E> self) {
		return RListModule.max(self);
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最大であった値に対応する元の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public static <E> E maxBy(List<E> self, final Proc<Integer, E> proc) {
		return RListModule.max(self, new Comparator<E>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(E o1, E o2) {
				return ((Comparable<E>) proc.exec(o1)).compareTo((E) proc.exec(o2));
			}
		});
	}
}
