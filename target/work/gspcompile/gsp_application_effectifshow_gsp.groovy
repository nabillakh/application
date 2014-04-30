import application.MailService
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_effectifshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)

def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()

printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
if(true && (effectifInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',64,['code':("Effectif.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',64,['bean':(effectifInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (effectifInstance?.prenom)) {
printHtmlPart(7)
invokeTag('message','g',71,['code':("Effectif.prenom.label"),'default':("Prenom : ")],-1)
invokeTag('fieldValue','g',71,['bean':(effectifInstance),'field':("prenom")],-1)
printHtmlPart(8)
}
printHtmlPart(10)
if(true && (effectifInstance?.equipe)) {
printHtmlPart(11)
invokeTag('message','g',79,['code':("effectif.equipe.label"),'default':("Equipe : ")],-1)
invokeTag('fieldValue','g',79,['bean':(effectifInstance),'field':("equipe")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
invokeTag('message','g',86,['code':("effectif.accountExpired.label"),'default':("Compte expiré : ")],-1)
invokeTag('fieldValue','g',86,['bean':(effectifInstance),'field':("accountExpired")],-1)
printHtmlPart(13)
invokeTag('message','g',93,['code':("effectif.accountLocked.label"),'default':("Compte bloqué : ")],-1)
invokeTag('fieldValue','g',93,['bean':(effectifInstance),'field':("accountLocked")],-1)
printHtmlPart(14)
if(true && (effectifInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',143,['code':("Effectif.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',143,['bean':(effectifInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (effectifInstance?.prenom)) {
printHtmlPart(7)
invokeTag('message','g',150,['code':("Effectif.prenom.label"),'default':("Prenom : ")],-1)
invokeTag('fieldValue','g',150,['bean':(effectifInstance),'field':("prenom")],-1)
printHtmlPart(8)
}
printHtmlPart(15)
if(true && (effectifInstance?.equipe)) {
printHtmlPart(11)
invokeTag('message','g',158,['code':("effectif.equipe.label"),'default':("Equipe : ")],-1)
invokeTag('fieldValue','g',158,['bean':(effectifInstance),'field':("equipe")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
invokeTag('message','g',165,['code':("effectif.accountExpired.label"),'default':("Compte expiré : ")],-1)
invokeTag('fieldValue','g',165,['bean':(effectifInstance),'field':("accountExpired")],-1)
printHtmlPart(16)
invokeTag('message','g',172,['code':("effectif.accountLocked.label"),'default':("Compte bloqué : ")],-1)
invokeTag('fieldValue','g',172,['bean':(effectifInstance),'field':("accountLocked")],-1)
printHtmlPart(17)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',190,['action':("ressource"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(19)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398757020459L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
