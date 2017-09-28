/**
 * 
 */
package fr.pizzeria.model;

import java.lang.annotation.*;
/**
 * @author joris
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString {

	boolean uppercase() default false;
	

}
