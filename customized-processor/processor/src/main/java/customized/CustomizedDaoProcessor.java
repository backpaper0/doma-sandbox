package customized;

import java.io.IOException;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.element.TypeElement;

import org.seasar.doma.internal.apt.DaoGenerator;
import org.seasar.doma.internal.apt.DaoProcessor;
import org.seasar.doma.internal.apt.Generator;
import org.seasar.doma.internal.apt.Options;
import org.seasar.doma.internal.apt.meta.DaoMeta;

@SupportedAnnotationTypes({ "org.seasar.doma.Dao" })
@SupportedOptions({ Options.TEST, Options.DEBUG, Options.DAO_PACKAGE,
        Options.DAO_SUBPACKAGE, Options.DAO_SUFFIX, Options.EXPR_FUNCTIONS,
        Options.SQL_VALIDATION, Options.VERSION_VALIDATION,
        Options.RESOURCES_DIR })
public class CustomizedDaoProcessor extends DaoProcessor {

    @Override
    protected Generator createGenerator(final TypeElement typeElement, final DaoMeta meta)
            throws IOException {
        return new DaoGenerator(processingEnv, typeElement, meta) {
            @Override
            public void generate() {
                iprint("/* Hello, world! */%n");
                super.generate();
            }
        };
    }
}
