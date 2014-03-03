/**
 * TODO コメント書く
 */
package hikaruna.javaRubyLikeApi;

import hikaruna.javaRubyLikeApi.module.RListModule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * RubyのArray.
 * @author hikaru
 *
 */
@SuppressWarnings("serial") // TODO いずれ番号を付ける
public class RList<E> extends ArrayList<E> {

	/**
	 * @see ArrayList#ArrayList()
	 */
	public RList() {
		super();
	}

	/**
	 * @see ArrayList#ArrayList(Collection)
	 */
	public RList(Collection<? extends E> c) {
		super(c);
	}

	/**
	 * @see ArrayList#ArrayList(int)
	 */
	public RList(int initialCapacity) {
		super(initialCapacity);
	}

	public RList<E> select(Proc<Boolean, E> proc) {
		return RListModule.select(this, proc);
	}

	/**
	 * 全ての要素を昇順にソートしたリストを生成して返します.
	 * @see RList#sort() sort
	 */
	public RList<E> sortBy() {
		return RListModule.sortBy(this);
	}

	/**
	 * ブロックの評価結果を昇順にソートしたリストを生成して返します.
	 */
	public RList<E> sortBy(Proc<?, E> proc) {
		return RListModule.sortBy(this, proc);
	}

	/**
	 * 全ての要素を昇順にソートしたリストを生成して返します.
	 */
	public RList<E> sort() {
		return RListModule.sort(this);
	}

	/**
	 * 指定されたコンパレータが示す順序に従ってソートしたリストを生成して返します.
	 */
	public RList<E> sort(Comparator<E> comparator) {
		return RListModule.sort(this, comparator);
	}

	/**
	 * 最小の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public E min() {
		return RListModule.min(this);
	}

	/**
	 * 最大の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public E max() {
		return RListModule.max(this);
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最小の要素を返します.
	 */
	public E min(Comparator<E> comparator) {
		return RListModule.min(this, comparator);
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最大の要素を返します.
	 */
	public E max(Comparator<E> comparator) {
		return RListModule.max(this, comparator);
	}

	/**
	 * 最小の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 * @see RList#min()
	 */
	public E minBy() {
		return RListModule.minBy(this);
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最小であった値に対応する元の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public E minBy(Proc<Integer, E> proc) {
		return RListModule.minBy(this, proc);
	}

	/**
	 * 最大の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 * @see RList#max()
	 */
	public E maxBy() {
		return RListModule.maxBy(this);
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最大であった値に対応する元の要素を返します.
	 * @exception ClassCastException 要素が比較可能でない({@link Comparable}を実装していない)場合にスローする.
	 */
	public E maxBy(Proc<Integer, E> proc) {
		return RListModule.maxBy(this, proc);
	}
}
