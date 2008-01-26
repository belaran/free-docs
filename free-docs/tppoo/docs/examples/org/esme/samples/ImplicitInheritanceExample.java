package org.esme.samples;
public class ImplicitInheritanceExample {
	public static void main(String[] args) {
		ImplicitInheritance o = new ImplicitInheritance();
		System.out.println(o.toString()); // This works with no code written !!!
		ImplicitInheritance o2 = new ImplicitInheritance();
		// This will also works, but watch out, it may not conclude what you want !
		if ( o.equals(o2) )
		{
			// ...
		}
	}
}
