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
	 * {@link Proc}をつけて読んだ場合、その評価値の自然順序によってソートする.
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
	 * 引数なしで読んだ場合、sortBy()と同様の動作をする.
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
	 * {@link Comparator}をつけて読んだ場合、その評価結果によってソートする.
	 */
	@Test
	public void testSort1() {
		RList<Integer> target = new RList<Integer>();
		target.add(4);
		target.add(-1);
		target.add(2);

		// 1に近い数字順
		RList<Integer> resultNearOne = target.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int base = 1;
				return Math.abs((base - o1)) - Math.abs((base - o2));
			}
		});

		assertEquals(Integer.valueOf(2), resultNearOne.get(0));
		assertEquals(Integer.valueOf(-1), resultNearOne.get(1));
		assertEquals(Integer.valueOf(4), resultNearOne.get(2));

		// 絶対値が多い順
		RList<Integer> resultAbs = target.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o2) - Math.abs(o1);
			}
		});

		assertEquals(Integer.valueOf(4), resultAbs.get(0));
		assertEquals(Integer.valueOf(2), resultAbs.get(1));
		assertEquals(Integer.valueOf(-1), resultAbs.get(2));
	}

	/**
	 * 順序付け不能な要素の場合、Comparetableへのキャスト例外を投げる.
	 */
	@Test(expected = ClassCastException.class)
	public void testSort2() {
		RList<Object> target = new RList<Object>();
		target.add(1);
		target.add(true);
		target.add("hoge");

		target.sort();
	}
	
	@Test
	public void testMin0() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		assertEquals(Integer.valueOf(-100), target.min());
	}

	@Test
	public void testMin1() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		// 20に一番近い数
		Integer result  = target.min(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int base = 20;
				return Math.abs(base - o1) - Math.abs(base - o2);
			}
		});
		
		assertEquals(Integer.valueOf(10), result);
	}

	@Test
	public void testMax0() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		assertEquals(Integer.valueOf(10), target.max());
	}

	@Test
	public void testMax1() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		// 20に一番遠い数
		Integer result  = target.max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int base = 20;
				return Math.abs(base - o1) - Math.abs(base - o2);
			}
		});
		
		assertEquals(Integer.valueOf(-100), result);
	}

	@Test
	public void testMinBy0() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		assertEquals(Integer.valueOf(-100), target.minBy());
	}

	@Test
	public void testMinBy1() {
		RList<String> target = new RList<String>();
		target.add("aa");
		target.add("bbb");
		target.add("c");

		String result  = target.minBy(new Proc<Integer, String>() {
			@Override
			public Integer exec(String arg) {
				return arg.length();
			}
		});
		
		assertEquals("c", result);
	}

	@Test
	public void testMaxBy0() {
		RList<Integer> target = new RList<Integer>();
		target.add(1);
		target.add(10);
		target.add(-100);

		assertEquals(Integer.valueOf(10), target.maxBy());
	}

	@Test
	public void testMaxBy1() {
		RList<String> target = new RList<String>();
		target.add("aa");
		target.add("bbb");
		target.add("c");

		String result  = target.maxBy(new Proc<Integer, String>() {
			@Override
			public Integer exec(String arg) {
				return arg.length();
			}
		});
		
		assertEquals("bbb", result);
	}

}
