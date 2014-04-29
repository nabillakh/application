import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_kanbanshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',6,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(5)
invokeTag('render','g',29,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
printHtmlPart(7)
invokeTag('message','g',81,['code':("kanban.nomKanban.label"),'default':("Nom du projet : ${kanbanInstance?.nomKanban}")],-1)
printHtmlPart(8)
invokeTag('message','g',86,['code':("kanban.description.label"),'default':("Description : ${kanbanInstance?.description}")],-1)
printHtmlPart(9)
invokeTag('message','g',91,['code':("kanban.phaseActuelle.label"),'default':("Etat d'avancement du projet : ${kanbanInstance?.phaseActuelle}")],-1)
printHtmlPart(10)
invokeTag('message','g',96,['code':("kanban.dateFinPlanifie.label"),'default':("Date de fin planifiée : ${kanbanInstance?.dateFinPlanifie}")],-1)
printHtmlPart(11)
invokeTag('message','g',141,['code':("kanban.nomKanban.label"),'default':("Nom du projet : ")],-1)
printHtmlPart(8)
invokeTag('message','g',146,['code':("kanban.description.label"),'default':("Description : ")],-1)
printHtmlPart(9)
invokeTag('message','g',151,['code':("kanban.phaseActuelle.label"),'default':("Etat d'avancement du projet : ")],-1)
printHtmlPart(10)
invokeTag('message','g',156,['code':("kanban.dateFinPlanifie.label"),'default':("Date de fin planifiée : ")],-1)
printHtmlPart(12)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
printHtmlPart(13)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: ofInstance, field: "phase"))
})
invokeTag('link','g',201,['action':("show"),'controller':("OF"),'id':(ofInstance.id)],2)
printHtmlPart(16)
expressionOut.print(ofInstance.kanban.nomKanban)
printHtmlPart(17)
invokeTag('formatDate','g',203,['format':("dd-MM-yyyy"),'date':(ofInstance.dateFinPlanifie)],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: ofInstance, field: "affectes"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('remoteFunction','g',228,['action':("obtenirCompteRendu"),'params':("\'kanban=\' + ${kanbanInstance.id}"),'update':("chatMessages")],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',233,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(22)
invokeTag('remoteFunction','g',243,['action':("updateCompteRendu"),'params':("\'message=\'+message+ '&kanban=\' + kanban"),'update':("temp")],-1)
printHtmlPart(23)
invokeTag('remoteFunction','g',252,['action':("obtenirCompteRendu"),'params':("\'kanban=\' + kanban"),'update':("chatMessages")],-1)
printHtmlPart(24)
invokeTag('render','g',290,['template':("/menues/mainright")],-1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398710435793L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
