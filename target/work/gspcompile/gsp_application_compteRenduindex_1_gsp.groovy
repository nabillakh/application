import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_compteRenduindex_1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/compteRendu/index_1.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('javascript','g',5,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textField','g',11,['name':("q"),'value':("")],-1)
printHtmlPart(5)
invokeTag('submitButton','g',12,['name':("Search For Users"),'id':("search_for_users_button")],-1)
printHtmlPart(6)
})
invokeTag('form','g',13,['controller':("searchable"),'name':("userSearchForm")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textArea','g',20,['name':("message"),'value':("")],-1)
printHtmlPart(8)
invokeTag('submitButton','g',21,['name':("Update Status"),'id':("update_status_button")],-1)
printHtmlPart(6)
})
invokeTag('formRemote','g',22,['url':([action: 'updateStatus']),'update':("messages"),'name':("updateStatusForm"),'onSuccess':("document.getElementById('message').value='';")],2)
printHtmlPart(9)
invokeTag('renderMessages','compteRendus',25,['messages':(compteRenduMessages)],-1)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',27,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398757020454L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
