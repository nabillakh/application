/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application
/**
 *
 * @author Nabil
 */
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.beans.propertyeditors.CustomDateEditor
import java.text.SimpleDateFormat

public class CustomDateEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy hh:mm a"), true))
    }

}