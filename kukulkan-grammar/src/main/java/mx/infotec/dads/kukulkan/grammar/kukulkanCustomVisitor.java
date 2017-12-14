package mx.infotec.dads.kukulkan.grammar;

import java.util.List;

import mx.infotec.dads.kukulkan.grammar.kukulkanParser.BlobValidatorsContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.DateTypesContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.EntityFieldContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.FieldTypeContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.NumericValidatorsContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.RequiredValidatorContext;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.StringValidatorsContext;

/**
 * KukulkanCustomVisitor, this is the main visitor for kukulkan grammar
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public class kukulkanCustomVisitor extends kukulkanBaseVisitor<Object> {
    @Override
    public Object visitDomainModel(kukulkanParser.DomainModelContext ctx) {
        ctx.entities.forEach(entity -> {
            System.out.println(entity.name.getText().toUpperCase());
            extractProperties(entity.fields);
        });
        return visitChildren(ctx);
    }

    private static void extractProperties(List<EntityFieldContext> fields) {
        fields.forEach(field -> {
            System.out.print(field.id.getText() + " ");
            findNotNull(field.type);
            System.out.println();
        });
    }

    private static void findNotNull(FieldTypeContext type) {
        if (type.stringFieldType() != null) {
            System.out.print(type.stringFieldType().name.getText());
            processStringConstraints(type.stringFieldType().constraints);
        } else if (type.numericFieldType() != null) {
            System.out.print(type.numericFieldType().name.getText());
            processNumericConstraints(type.numericFieldType().constraints);
        } else if (type.booleanFieldType() != null) {
            System.out.print(type.booleanFieldType().name.getText()+" ");
            if (type.booleanFieldType().required != null) {
                System.out.print(type.booleanFieldType().required.getText());
            }

        } else if (type.dateFieldType() != null) {
            processDataFieldType(type.dateFieldType().type);
            if (type.dateFieldType().required != null) {
                System.out.println("" + type.dateFieldType().required.getText());
            }
        } else if (type.blobFieldType() != null) {
            processBlobConstraint(type.blobFieldType().constraints);
        } else {
        }

    }

    private static void processDataFieldType(DateTypesContext ctx) {
        if (ctx.DATE() != null) {
            System.out.print(ctx.DATE().getText());
        } else if (ctx.LOCAL_DATE() != null) {
            System.out.print(ctx.LOCAL_DATE().getText());
        } else if (ctx.ZONED_DATETIME() != null) {
            System.out.print(ctx.ZONED_DATETIME().getText());
        } else if (ctx.INSTANT() != null) {
            System.out.print(ctx.INSTANT().getText());
        }
    }

    private static void processBlobConstraint(List<BlobValidatorsContext> constraints) {

    }

    private static void processNumericConstraints(RequiredValidatorContext ctx) {

    }

    private static void processNumericConstraints(List<NumericValidatorsContext> ctx) {
        // TODO Auto-generated method stub

    }

    private static void processStringConstraints(List<StringValidatorsContext> ctx) {
        // TODO Auto-generated method stub

    }
}
