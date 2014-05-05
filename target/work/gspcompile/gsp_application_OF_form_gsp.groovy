import application.PP.OF
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_OF_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/OF/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: OFInstance, field: 'chargePlanifiee', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("OF.chargePlanifiee.label"),'default':("Charge Planifiee")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("chargePlanifiee"),'value':(fieldValue(bean: OFInstance, field: 'chargePlanifiee'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: OFInstance, field: 'affectes', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("OF.affectes.label"),'default':("Affectes")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['name':("affectes"),'from':(application.RH.Effectif.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(OFInstance?.affectes*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: OFInstance, field: 'dateDebutPlanifie', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("OF.dateDebutPlanifie.label"),'default':("Date Debut Planifie")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',28,['name':("dateDebutPlanifie"),'precision':("day"),'value':(OFInstance?.dateDebutPlanifie)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: OFInstance, field: 'dateFinPlanifie', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("OF.dateFinPlanifie.label"),'default':("Date Fin Planifie")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',37,['name':("dateFinPlanifie"),'precision':("day"),'value':(OFInstance?.dateFinPlanifie)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: OFInstance, field: 'kanban', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("OF.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(6)
invokeTag('select','g',46,['id':("kanban"),'name':("kanban.id"),'from':(application.PP.Kanban.list()),'optionKey':("id"),'required':(""),'value':(OFInstance?.kanban?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: OFInstance, field: 'phase', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("OF.phase.label"),'default':("Phase")],-1)
printHtmlPart(6)
invokeTag('select','g',55,['id':("phase"),'name':("phase.id"),'from':(application.PP.Phase.list()),'optionKey':("id"),'required':(""),'value':(OFInstance?.phase?.id),'class':("many-to-one")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399041410841L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
