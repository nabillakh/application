import application.pilotage.PdpKanbanEvent
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_pdpKanbanEvent_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pdpKanbanEvent/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: pdpKanbanEventInstance, field: 'imputations', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("pdpKanbanEvent.imputations.label"),'default':("Imputations")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("imputations"),'from':(application.communication.Event.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(pdpKanbanEventInstance?.imputations*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpKanbanEventInstance, field: 'kanban', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("pdpKanbanEvent.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("kanban"),'name':("kanban.id"),'from':(application.PP.Kanban.list()),'optionKey':("id"),'required':(""),'value':(pdpKanbanEventInstance?.kanban?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpKanbanEventInstance, field: 'kanbanReel', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("pdpKanbanEvent.kanbanReel.label"),'default':("Kanban Reel")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',28,['name':("kanbanReel"),'value':(pdpKanbanEventInstance?.kanbanReel)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpKanbanEventInstance, field: 'pdp', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("pdpKanbanEvent.pdp.label"),'default':("Pdp")],-1)
printHtmlPart(5)
invokeTag('select','g',37,['id':("pdp"),'name':("pdp.id"),'from':(application.pilotage.Pdp.list()),'optionKey':("id"),'required':(""),'value':(pdpKanbanEventInstance?.pdp?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331688L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
