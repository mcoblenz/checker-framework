package org.checkerframework.framework.qual;

import java.lang.annotation.*;

/**
 * A meta-annotation indicating that an annotation type prevents whole-program
 * inference. For example, if the definition of {@code &#064;Inject} is
 * meta-annotated with {@code &#064;IgnoreInWholeProgramInference}:<br>
 *   <tt>@IgnoreInWholeProgramInference</tt><br>
 *   <tt>@interface Inject { }</tt><br>
 * then no type qualifier will be inferred for any field annotated by
 * {@code &#064;Inject}.
 *
 * <p>
 * This is appropriate for fields that are set reflectively, so there are
 * no calls in client code that type inference can learn from.
 * Examples of qualifiers that should be meta-annotated with
 * {@code @IgnoreInWholeProgramInference} include
 * <a href="https://docs.oracle.com/javaee/7/api/javax/inject/Inject.html">{@code @Inject}</a>,
 * <a href="https://docs.oracle.com/javaee/7/api/javax/inject/Singleton.html">{@code @Singleton}</a>,
 * and
 * <a href="http://types.cs.washington.edu/plume-lib/api/plume/Option.html">{@code @Option}</a>.
 *
 * <p>
 * See {@link org.checkerframework.common.wholeprograminference.WholeProgramInferenceScenes#updateInferredFieldType}
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface IgnoreInWholeProgramInference { }
