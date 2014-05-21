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
expressionOut.print(kanbanInstance.chefProjet.nom)
printHtmlPart(15)
expressionOut.print(kanbanInstance.chefProjet.prenom)
printHtmlPart(16)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(17)
createTagBody(2, {->
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(15)
})
invokeTag('link','g',82,['controller':("OF"),'action':("show"),'id':(ofInstance.id)],2)
printHtmlPart(18)
invokeTag('formatDate','g',83,['format':("dd-MM-yyyy"),'date':(ofInstance.dateFinPlanifie)],-1)
printHtmlPart(19)
if(true && (ofInstance.affectes)) {
printHtmlPart(20)
loop:{
int j = 0
for( aff in (ofInstance.affectes) ) {
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(aff.effectif.nom)
printHtmlPart(15)
expressionOut.print(aff.effectif.prenom)
printHtmlPart(22)
})
invokeTag('link','g',87,['controller':("Effectif"),'action':("show"),'id':(aff.effectif.id)],4)
printHtmlPart(23)
j++
}
}
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('hiddenField','g',106,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.nomKanban)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',107,['name':("chargePlanifiee"),'id':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee)],-1)
printHtmlPart(27)
loop:{
int k = 0
for( ofInstance in (ofs) ) {
printHtmlPart(28)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(29)
expressionOut.print(ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100)
printHtmlPart(30)
expressionOut.print(ofInstance.chargeAgenda)
printHtmlPart(31)
expressionOut.print(ofInstance.chargePlanifiee)
printHtmlPart(32)
k++
}
}
printHtmlPart(33)
invokeTag('hiddenField','g',163,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(34)
invokeTag('remoteFunction','g',170,['controller':("message"),'action':("obtenirMessage"),'params':("\'kanban=\' + ${kanbanInstance.id}"),'update':("chatMessages")],-1)
printHtmlPart(35)
invokeTag('remoteFunction','g',182,['controller':("message"),'action':("posterMessageKanban"),'params':("\'message=\'+message+ '&kanban=\' + kanban"),'update':("temp")],-1)
printHtmlPart(36)
invokeTag('remoteFunction','g',191,['controller':("message"),'action':("obtenirMessage"),'params':("\'kanban=\' + kanban"),'update':("chatMessages")],-1)
printHtmlPart(37)
invokeTag('render','g',225,['template':("/menues/mainright")],-1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331668L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
