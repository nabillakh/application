import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_eventindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',59,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',60,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',60,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',61,[:],1)
printHtmlPart(4)
invokeTag('render','g',64,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
loop:{
int i = 0
for( ofInstance in (mesOF) ) {
printHtmlPart(6)
expressionOut.print(ofInstance.id)
printHtmlPart(7)
expressionOut.print(ofInstance.kanban.nomKanban)
printHtmlPart(8)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
invokeTag('render','g',220,['template':("/menues/mainright")],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398258405434L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
