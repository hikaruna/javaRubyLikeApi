/**
 * TODO コメント書く
 */
package hikaruna.javaRubyLikeApi;

import hikaruna.javaRubyLikeApi.module.RListModule;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * RubyのArray.
 * @author hikaru
 *
 */
@SuppressWarnings("serial") // TODO いずれ番号を付ける
public class RList<E> extends ArrayList<E> {

	public RList<E> select(Proc<Boolean, E> proc) {
		return RListModule.select(this, proc);
	}

	public RList<E> sortBy() {
		return null;
	}

	public RList<E> sortBy(Proc<?, E> proc) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public RList<E> sort() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public RList<E> sort(Comparator<E> comparator) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
