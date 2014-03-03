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
	 */
	public E min() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 最大の要素を返します.
	 */
	public E max() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最小の要素を返します.
	 */
	public E min(Comparator<Integer> comparator) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * {@link Comparator}の評価結果で各要素の大小判定を行い、最大の要素を返します.
	 */
	public E max(Comparator<Integer> comparator) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 最小の要素を返します.
	 * @see RList#min()
	 */
	public E minBy() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最小であった値に対応する元の要素を返します.
	 */
	public E minBy(Proc<Integer, String> proc) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 最大の要素を返します.
	 * @see RList#max()
	 */
	public E maxBy() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * 各要素を順番に{@link Proc}に渡して実行し、その評価結果を比較して、最大であった値に対応する元の要素を返します.
	 */
	public E maxBy(Proc<Integer, String> proc) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
