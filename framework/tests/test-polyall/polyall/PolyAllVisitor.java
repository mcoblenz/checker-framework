package polyall;

import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeValidator;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.source.Result;
import org.checkerframework.framework.type.AnnotatedTypeFactory;
import org.checkerframework.framework.type.AnnotatedTypeMirror.AnnotatedDeclaredType;
import org.checkerframework.framework.util.AnnotatedTypes;
import org.checkerframework.javacutil.AnnotationUtils;

import javax.lang.model.element.AnnotationMirror;

import com.sun.source.tree.Tree;

import polyall.quals.H1Invalid;

public class PolyAllVisitor
        extends BaseTypeVisitor<PolyAllAnnotatedTypeFactory> {

    public PolyAllVisitor(BaseTypeChecker checker) {
        super(checker);
    }

    @Override
    protected BaseTypeValidator createTypeValidator() {
        return new PolyAllTypeValidator(checker, this, atypeFactory);
    }

    private final class PolyAllTypeValidator extends BaseTypeValidator {

        public PolyAllTypeValidator(BaseTypeChecker checker,
                BaseTypeVisitor<?> visitor, AnnotatedTypeFactory atypeFactory) {
            super(checker, visitor, atypeFactory);
        }

        @Override
        public Void visitDeclared(AnnotatedDeclaredType type, Tree p) {
            AnnotationMirror h1Invalid = AnnotationUtils.fromClass(elements,
                                                              H1Invalid.class);
            if (AnnotatedTypes.containsModifier(type, h1Invalid)) {
                checker.report(Result.failure("polyall.h1invalid.forbidden",
                        type.getAnnotations(), type.toString()), p);
            }
            return super.visitDeclared(type, p);
        }
    }
}
