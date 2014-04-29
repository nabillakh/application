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
invokeTag('textField','g',9,['name':("nomKanban"),'value':(kanbanInstance?.nomKanban),'class':("span12")],-1)
printHtmlPart(2)
invokeTag('message','g',16,['code':("kanban.description.label"),'default':("Description")],-1)
printHtmlPart(1)
invokeTag('textField','g',19,['name':("description"),'value':(kanbanInstance?.description),'class':("span12")],-1)
printHtmlPart(3)
invokeTag('select','g',27,['multiple':("multiple"),'id':("multiSelect"),'name':("famille.id"),'from':(application.PP.Famille.list()),'optionKey':("id"),'required':(""),'value':(kanbanInstance?.famille?.id),'class':("span12 with-search")],-1)
printHtmlPart(4)
invokeTag('select','g',34,['multiple':("multiple"),'id':("multiSelect"),'name':("ordo.id"),'from':(application.PP.Ordonnancement.list()),'optionKey':("id"),'required':(""),'value':(kanbanInstance?.ordo?.id),'class':("span12 with-search")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',45,['name':("dateLancement"),'value':(kanbanInstance?.dateLancement),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',63,['name':("dateFinPlanifie"),'value':(kanbanInstance?.dateFinPlanifie),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(7)
invokeTag('message','g',73,['code':("kanban.charge.label"),'default':("Charge")],-1)
printHtmlPart(1)
invokeTag('field','g',76,['name':("chargePlanifiee"),'value':(fieldValue(bean: kanbanInstance, field: 'chargePlanifiee')),'class':("span12")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398073928097L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
