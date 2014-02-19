/**
 * TODO コメント書く
 */
package hikaruna.javaRubyLikeApi;

import hikaruna.javaRubyLikeApi.module.RListModule;

import java.util.ArrayList;

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
}
