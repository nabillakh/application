import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_kanban_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(kanbanInstance?.id)
printHtmlPart(1)
invokeTag('message','g',5,['code':("kanban.nomKanban.label"),'default':("Nom du projet")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("nomKanban"),'class':("span12"),'value':(kanbanInstance?.nomKanban)],-1)
printHtmlPart(3)
invokeTag('message','g',17,['code':("kanban.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',21,['name':("description"),'class':("span12"),'value':(kanbanInstance?.description)],-1)
printHtmlPart(4)
invokeTag('select','g',30,['id':("multiSelect"),'name':("chefProjet"),'value':(kanbanInstance.chefProjet?.id),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(5)
invokeTag('select','g',37,['id':("multiSelect"),'name':("famille"),'value':(kanbanInstance.famille?.id),'from':(application.PP.Famille.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(6)
invokeTag('select','g',44,['id':("multiSelect"),'name':("ordo"),'value':(kanbanInstance.ordo?.id),'from':(application.PP.Ordonnancement.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(7)
expressionOut.print(dateDeb)
printHtmlPart(8)
expressionOut.print(dateDeb)
printHtmlPart(9)
expressionOut.print(dateFin)
printHtmlPart(8)
expressionOut.print(dateFin)
printHtmlPart(10)
invokeTag('message','g',75,['code':("kanban.charge.label"),'default':("Charge")],-1)
printHtmlPart(2)
invokeTag('field','g',79,['name':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee),'class':("span12")],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331664L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
