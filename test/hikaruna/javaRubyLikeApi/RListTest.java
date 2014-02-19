/**
 * 
 */
package hikaruna.javaRubyLikeApi;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author hikaru
 *
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

}
