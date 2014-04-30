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
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(5)
invokeTag('render','g',10,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
invokeTag('message','g',23,['code':("kanban.nomKanban.label"),'default':("Projet : ${kanbanInstance?.nomKanban}")],-1)
printHtmlPart(7)
invokeTag('message','g',33,['code':("kanban.description.label"),'default':("Description : ${kanbanInstance?.description}")],-1)
printHtmlPart(8)
invokeTag('message','g',36,['code':("kanban.phaseActuelle.label"),'default':("Etat d'avancement du projet : ${kanbanInstance?.phaseActuelle.nom}")],-1)
printHtmlPart(9)
invokeTag('formatDate','g',40,['code':("kanban.dateFinPlanifie.label"),'format':("dd-MM-yyyy"),'date':(kanbanInstance?.dateFinPlanifie)],-1)
printHtmlPart(10)
expressionOut.print(kanbanInstance?.chargePlanifiee)
printHtmlPart(11)
expressionOut.print(kanbanInstance?.getAvancementAgenda())
printHtmlPart(12)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(13)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(14)
invokeTag('hiddenField','g',81,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',82,['name':("chargePlanifiee"),'id':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',83,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(16)
loop:{
int k = 0
for( ofInstance in (ofs) ) {
printHtmlPart(17)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(18)
expressionOut.print(ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100)
printHtmlPart(19)
expressionOut.print(ofInstance.chargeAgenda)
printHtmlPart(20)
expressionOut.print(ofInstance.chargePlanifiee)
printHtmlPart(21)
k++
}
}
printHtmlPart(22)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
printHtmlPart(23)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(24)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(25)
expressionOut.print(ofInstance.kanban.nomKanban)
printHtmlPart(26)
invokeTag('formatDate','g',137,['format':("dd-MM-yyyy"),'date':(ofInstance.dateFinPlanifie)],-1)
printHtmlPart(27)
expressionOut.print(fieldValue(bean: ofInstance, field: "affectes"))
printHtmlPart(28)
i++
}
}
printHtmlPart(29)
invokeTag('remoteFunction','g',160,['action':("obtenirCompteRendu"),'params':("\'kanban=\' + ${kanbanInstance.id}"),'update':("chatMessages")],-1)
printHtmlPart(30)
invokeTag('hiddenField','g',165,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(31)
invokeTag('remoteFunction','g',175,['action':("updateCompteRendu"),'params':("\'message=\'+message+ '&kanban=\' + kanban"),'update':("temp")],-1)
printHtmlPart(32)
invokeTag('remoteFunction','g',184,['action':("obtenirCompteRendu"),'params':("\'kanban=\' + kanban"),'update':("chatMessages")],-1)
printHtmlPart(33)
invokeTag('render','g',231,['template':("/menues/mainright")],-1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398785841613L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
