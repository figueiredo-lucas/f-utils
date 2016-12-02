package br.com.futils.executions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

import br.com.futils.exceptions.FUtilsException;
import br.com.futils.interfaces.IValidate;

public final class FUtils {
	
	private static String getEncapsulatedFieldName(final String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	public static class Lists {

		public static <T> T find(final List<T> list, final IValidate<T> validator) {
			for (T elem : list) {
				if (validator.validate(elem)) {
					return elem;
				}
			}
			return null;
		}
		
		public static <T> T find(final List<T> list, final T compare) {
			for (T elem : list) {
				if (elem.equals(compare)) {
					return elem;
				}
			}
			return null;
		}
		
		public static <T> T find(final List<T> list, final String field, final Object compare) throws FUtilsException {
			for (T elem : list) {
				try {
					final String methodName = getEncapsulatedFieldName(elem.getClass().getDeclaredField(field).getName());
					if (Objects.equals(compare, elem.getClass().getDeclaredMethod(methodName).invoke(elem))) {
						return elem;
					}
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException ex) {
					throw new FUtilsException("Field not accessible", ex);
				} catch (NoSuchFieldException ex) {
					throw new FUtilsException("Field not found", ex);
				} catch (InvocationTargetException | NoSuchMethodException ex) {
					throw new FUtilsException("Invalid Method", ex);
				}
			}
			return null;
		}
	}
}
