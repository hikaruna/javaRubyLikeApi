/**
 * 
 */
package hikaruna.javaRubyLikeApi;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

/**
 * @author hikaru
 */
public class RListTest {

	@Test
	public void testSelect() {
		RList<String> target = new RList<String>();
		target.add("hoge");
		target.add("piyo");
		target.add("foo");
		target.add("bar");

		RList<String> result = target.select(new Proc<Boolean, String>() {
			@Override
			public Boolean exec(String arg) {
				return arg.length() < 4;
			}
		});

		assertEquals(2, result.size());
		assertEquals(target.get(2), result.get(0));
		assertEquals(target.get(3), result.get(1));
	}

	/**
	 * 引数なしで読んだ場合要素の自然順序でソートする.
	 */
	@Test
	public void testSortBy0() {
		RList<String> target = new RList<String>();
		target.add("a");
		target.add("c");
		target.add("b");

		RList<String> result = target.sortBy();

		assertEquals("a", result.get(0));
		assertEquals("b", result.get(1));
		assertEquals("c", result.get(2));
	}

	/**
	 * {@link Proc}をつけて読んだ場合、その評価値の自然順序によってソートされること.
	 */
	@Test
	public void testSortBy1() {
		RList<String> target = new RList<String>();
		target.add("aaa");
		target.add("cc");
		target.add("b");

		RList<String> result = target.sortBy(new Proc<Integer, String>() {
			@Override
			public Integer exec(String arg) {
				return arg.length();
			}
		});

		assertEquals("b", result.get(0));
		assertEquals("cc", result.get(1));
		assertEquals("aaa", result.get(2));
	}

	/**
	 * 引数なしで読んだ場合、sortBy()と同様の動作をすること.
	 */
	@Test
	public void testSort0() {
		RList<String> target = new RList<String>();
		target.add("a");
		target.add("c");
		target.add("b");

		RList<String> expected = target.sortBy();
		RList<String> result = target.sort();

		assertEquals(expected, result);
	}

	/**
	 * {@link Comparator}をつけて読んだ場合、その評価結果によってソートされること.
	 */
	@Test
	public void testSort1() {
		RList<Integer> target = new RList<Integer>();
		target.add(4);
		target.add(-1);
		target.add(2);

		// 1に近い数字順
		RList<Integer> resultNearTen = target.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int base = 1;
				return (base - o1) - (base - o2);
			}
		});

		assertEquals(Integer.valueOf(2), resultNearTen.get(0));
		assertEquals(Integer.valueOf(-1), resultNearTen.get(1));
		assertEquals(Integer.valueOf(4), resultNearTen.get(2));

		// 絶対値が多い順
		RList<Integer> resultNearZero = target.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o2) - Math.abs(o1);
			}
		});

		assertEquals(Integer.valueOf(4), resultNearZero.get(0));
		assertEquals(Integer.valueOf(2), resultNearZero.get(1));
		assertEquals(Integer.valueOf(-1), resultNearZero.get(2));
	}
}
