package br.com.futils.test;

import java.util.ArrayList;
import java.util.List;

import br.com.futils.exceptions.FUtilsException;
import br.com.futils.executions.FUtils.Lists;
import br.com.futils.interfaces.IValidate;

public class Test {

	public static void main(String[] args) throws FUtilsException {
		final List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		final String retorno = Lists.find(list, new IValidate<String>() {
			@Override
			public boolean validate(final String parameter) {
				return parameter == "a";
			}
		});
		System.out.println(retorno);

		final String retorno2 = Lists.find(list, "b");
		System.out.println(retorno2);

		final List<ComplexClass> list2 = new ArrayList<>();
		final ComplexClass obj = new ComplexClass();
		obj.setCampo1("Campo 1");
		obj.setCampo2(24L);

		final ComplexClass obj2 = new ComplexClass();
		obj2.setCampo1("Campo 2");
		obj2.setCampo2(25L);

		final ComplexClass obj3 = new ComplexClass();
		obj3.setCampo1("Campo 3");
		obj3.setCampo2(26L);

		final ComplexClass obj4 = new ComplexClass();
		obj4.setCampo1("Campo 3");
		obj4.setCampo2(24L);

		list2.add(obj);
		list2.add(obj2);
		list2.add(obj3);
		list2.add(obj4);
		final ComplexClass retorno3 = Lists.find(list2, "campo1", "Campo 1");
		System.out.println(retorno3);
		
		final ComplexClass retorno4 = Lists.find(list2, new IValidate<ComplexClass>() {
			@Override
			public boolean validate(final ComplexClass parameter) {
				return parameter.getCampo1().equals("Campo 3") && parameter.getCampo2().equals(24L);
			}
		});
		System.out.println(retorno4);
	}

}
