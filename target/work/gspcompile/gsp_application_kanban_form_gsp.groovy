import application.PP.Kanban
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
invokeTag('message','g',6,['code':("kanban.nomKanban.label"),'default':("Nom du projet")],-1)
printHtmlPart(1)
invokeTag('textField','g',10,['name':("nomKanban"),'class':("span12")],-1)
printHtmlPart(2)
invokeTag('message','g',18,['code':("kanban.description.label"),'default':("Description")],-1)
printHtmlPart(1)
invokeTag('textField','g',22,['name':("description"),'class':("span12")],-1)
printHtmlPart(3)
invokeTag('select','g',31,['id':("multiSelect"),'name':("famille"),'from':(application.PP.Famille.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(4)
invokeTag('select','g',38,['id':("multiSelect"),'name':("ordo"),'from':(application.PP.Ordonnancement.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(5)
invokeTag('field','g',49,['type':("date"),'name':("dateLancement"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(6)
invokeTag('field','g',62,['type':("date"),'name':("dateFinPlanifie"),'value':("dateFinPlanifie"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(7)
invokeTag('message','g',69,['code':("kanban.charge.label"),'default':("Charge")],-1)
printHtmlPart(1)
invokeTag('field','g',73,['name':("chargePlanifiee"),'class':("span12")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399052850613L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
