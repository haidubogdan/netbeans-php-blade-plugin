package org.netbeans.modules.php.blade.editor.indexing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.blade.editor.cache.QueryCache;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.index.PHPIndexer;
import org.netbeans.modules.php.editor.index.Signature;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 * this is experimental to be investigated in the future
 *
 * @author bhaidu
 */
public class PhpIndexUtils {

    private final static QueryCache<String, Collection<PhpIndexResult>> cache = new QueryCache();
    
    private static final Map<Integer, PhpIndexUtils> QUERY_SUPPORT_INSTANCES = new WeakHashMap<>();
    /**
     * class query without namespace
     *
     * @param fo
     * @param prefix
     * @return
     */
    public static Collection<PhpIndexResult> queryClass(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Project projectOwner = ProjectConvertors.getNonConvertorOwner(fo);
        QueryCache<String, Collection<PhpIndexResult>> selfCache = null;
        if (projectOwner != null) {
            int pathHash = projectOwner.getProjectDirectory().toString().hashCode();
            if (PhpIndexUtils.QUERY_SUPPORT_INSTANCES.containsKey(pathHash)) {
                PhpIndexUtils indexUtils = QUERY_SUPPORT_INSTANCES.get(pathHash);
                selfCache = indexUtils.getQueryCache();
                if (selfCache.containsKey(prefix)) {
                    return selfCache.get(prefix).get();
                }
            } else {
                QUERY_SUPPORT_INSTANCES.put(pathHash, new PhpIndexUtils());
            }
        }
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CLASS,
                    queryPrefix, QuerySupport.Kind.PREFIX, new String[]{
                        PHPIndexer.FIELD_CLASS,});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String fullName = sig.string(1);
                    if (fullName.length() > 0 && fullName.startsWith(prefix)) {
                        results.add(new PhpIndexResult(fullName, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        if (selfCache != null && !results.isEmpty()){
            selfCache.put(prefix, results);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryNamespaceClasses(String prefix,
            String namespace, FileObject fo) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase() + ".*" + namespace.replace("\\", "\\\\") + ".*";

        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(
                    PHPIndexer.FIELD_CLASS, queryPrefix, QuerySupport.Kind.REGEXP, new String[]{
                        PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String fullName = sig.string(1);
                    String classNamespace = sig.string(4);
                    if (fullName.length() > 0
                            && classNamespace.length() > 0
                            && classNamespace.startsWith(namespace)) {
                        results.add(new PhpIndexResult(classNamespace + "\\" + fullName, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryNamespaceClassesName(String prefix,
            String namespace, FileObject fo) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase() + ".*" + namespace.replace("\\", "\\\\") + ";.*";

        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(
                    PHPIndexer.FIELD_CLASS, queryPrefix, QuerySupport.Kind.REGEXP, new String[]{
                        PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String fullName = sig.string(1);
                    String classNamespace = sig.string(4);
                    if (fullName.length() > 0
                            && classNamespace.length() > 0
                            && classNamespace.startsWith(namespace)) {
                        results.add(new PhpIndexResult(fullName, 
                                classNamespace + "\\" + fullName, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryExactNamespaceClasses(String identifier,
            String namespace, FileObject fo) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = identifier.toLowerCase() + ".*" + namespace.replace("\\", "\\\\") + ".*";
        //queryPrefix = identifier.toLowerCase() + ".*";
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(
                    PHPIndexer.FIELD_CLASS, queryPrefix, QuerySupport.Kind.REGEXP, new String[]{
                        PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String fullName = sig.string(1);
                    String classNamespace = sig.string(4);
                    if (fullName.equals(identifier)
                            && classNamespace.length() > 0
                            && classNamespace.startsWith(namespace)) {
                        results.add(new PhpIndexResult(classNamespace + "\\" + fullName, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryExactClass(FileObject fo, String identifier) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = identifier.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CLASS,
                    queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);
                    if (name.length() > 0 && name.equals(identifier)) {
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexFunctionResult> queryFunctions(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexFunctionResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_BASE, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_BASE});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_BASE);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.startsWith(prefix)) {
                        Integer offset = sig.integer(2);
                        String params = sig.string(3);
                        results.add(new PhpIndexFunctionResult(
                                name, indexFile,
                                PhpIndexResult.Type.FUNCTION,
                                new OffsetRange(offset, offset + name.length()),
                                parseParameters(params)
                        ));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexFunctionResult> queryExactFunctions(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexFunctionResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_BASE, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_BASE});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_BASE);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
                        Integer offset = sig.integer(2);
                        String params = sig.string(3);
                        results.add(new PhpIndexFunctionResult(name,
                                indexFile, PhpIndexResult.Type.FUNCTION,
                                new OffsetRange(offset, offset + name.length()),
                                parseParameters(params)
                        ));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexFunctionResult> queryExactClassMethods(FileObject fo, String method, String className) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexFunctionResult> results = new ArrayList<>();
        //for the moment a quick hack
        //maybe send the classNamePath directly?
        String regexQuery = method.toLowerCase() + ";(.)*(" + className.replace("_", "/") + ")(.)*";
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_METHOD, regexQuery,
                    QuerySupport.Kind.REGEXP, new String[]{PHPIndexer.FIELD_METHOD});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_METHOD);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(method)) {
                        Integer offset = sig.integer(2);
                        String params = sig.string(3);
                        results.add(new PhpIndexFunctionResult(name,
                                indexFile, PhpIndexResult.Type.FUNCTION,
                                new OffsetRange(offset, offset + name.length()),
                                parseParameters(params)
                        ));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    /**
     * todo might add project filter
     *
     * @param fo
     * @param method
     * @param className
     * @return
     */
    public static Collection<PhpIndexFunctionResult> queryClassMethods(FileObject fo, String method, String className) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexFunctionResult> results = new ArrayList<>();
        //for the moment a quick hack
        //maybe send the classNamePath directly?
        String regexQuery = method.toLowerCase() + "(.)*;(.)*(" + className.replace("_", "/") + ")(.)*";
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_METHOD, regexQuery,
                    QuerySupport.Kind.REGEXP, new String[]{PHPIndexer.FIELD_METHOD});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_METHOD);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.startsWith(method)) {
                        Integer offset = sig.integer(2);
                        String params = sig.string(3);
                        results.add(new PhpIndexFunctionResult(name,
                                indexFile, PhpIndexResult.Type.FUNCTION,
                                new OffsetRange(offset, offset + name.length()),
                                parseParameters(params)
                        ));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryConstants(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_CONST});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.startsWith(prefix)) {
                        Integer offset = sig.integer(2);
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.CONSTANT, new OffsetRange(offset, offset + name.length())));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryNamespace(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        Collection<String> namespaces = new ArrayList<>();
        //subfolders with lowercase ; rootFolder
        //third signature namespace
        //the first el is the folder
        String originalPrefix = prefix;
        String[] queryItems = prefix.split("\\\\");
        if (queryItems.length == 0) {
            return results;
        }
        boolean endsWithSlash = false;
        if (prefix.endsWith("\\\\")) {
            prefix = prefix.substring(0, prefix.length() - 2);
            endsWithSlash = true;
        }
        int lastSlashIndex = prefix.lastIndexOf('\\');

        if (lastSlashIndex > -1 && lastSlashIndex == prefix.length() - 1) {
            prefix = prefix.substring(0, prefix.length() - 2);
        }

        String queryPrefix = lastSlashIndex > 0 && prefix.length() > lastSlashIndex ? prefix.substring(0, lastSlashIndex - 1).toLowerCase() : prefix.toLowerCase();

        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(
                    PHPIndexer.FIELD_TOP_LEVEL, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{
                        PHPIndexer.FIELD_NAMESPACE, PHPIndexer.FIELD_TOP_LEVEL});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                String topFieldValue = indexResult.getValue(PHPIndexer.FIELD_TOP_LEVEL);
                //internal php index
                if (!endsWithSlash && topFieldValue.startsWith(prefix.toLowerCase())) {
                    String firstValue = indexResult.getValue(PHPIndexer.FIELD_NAMESPACE);
                    if (firstValue == null || firstValue.isEmpty()) {
                        continue;
                    }
                    Signature sig = Signature.get(firstValue);

                    String name = sig.string(1);
                    String namespace = sig.string(2);

                    String fullNamespace = "";

                    if (!namespace.isEmpty()) {
                        fullNamespace = namespace + "\\";
                    }

                    fullNamespace += name;

                    //just one namespace is enough
                    if (fullNamespace.startsWith(originalPrefix) && !namespaces.contains(fullNamespace)) {
                        namespaces.add(fullNamespace);
                        results.add(new PhpIndexResult(fullNamespace, indexFile, PhpIndexResult.Type.NAMESPACE, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryClassConstants(FileObject fo, String prefix, String ownerClass) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CLASS_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{
                PHPIndexer.FIELD_CLASS_CONST, PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String classOwnerName = indexResult.getValue(PHPIndexer.FIELD_CLASS);
                if (!classOwnerName.startsWith(ownerClass.toLowerCase())) {
                    continue;
                }
                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.startsWith(prefix)) {
                        Integer offset = sig.integer(2);
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.CONSTANT, new OffsetRange(offset, offset + name.length())));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryExactClassConstants(FileObject fo, String prefix, String ownerClass) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CLASS_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{
                PHPIndexer.FIELD_CLASS_CONST, PHPIndexer.FIELD_CLASS});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String classOwnerName = indexResult.getValue(PHPIndexer.FIELD_CLASS);
                if (!classOwnerName.startsWith(ownerClass.toLowerCase() + ";")) {
                    continue;
                }
                String[] values = indexResult.getValues(PHPIndexer.FIELD_CLASS_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
                        Integer offset = sig.integer(2);
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.CONSTANT, new OffsetRange(offset, offset + name.length())));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryExactConstants(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_CONST});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
                        Integer offset = sig.integer(2);
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.FUNCTION, new OffsetRange(offset, offset + name.length())));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    static List<String> parseParameters(final String signature) {
        List<String> retval = new ArrayList<>();
        if (signature != null && signature.length() > 0) {
            final String regexp = String.format("\\%s", ","); //NOI18N

            for (String sign : signature.split(regexp)) {
                try {
                    final String param = parseOneParameter(sign);
                    if (param != null) {
                        retval.add(param);
                    }
                } catch (NumberFormatException originalException) {
                    final String message = String.format("%s [for signature: %s]", originalException.getMessage(), signature); //NOI18N
                    final NumberFormatException formatException = new NumberFormatException(message);
                    formatException.initCause(originalException);
                    throw formatException;
                }
            }
        }
        return retval;
    }

    static String parseOneParameter(String sig) {
        String retval = null;
        final String regexp = String.format("\\%s", ":"); //NOI18N
        String[] parts = sig.split(regexp);
        if (parts.length > 0) {
            String paramName = parts[0];
            boolean isRawType = Integer.parseInt(parts[2]) > 0;
            boolean isMandatory = Integer.parseInt(parts[4]) > 0;
            boolean isReference = Integer.parseInt(parts[5]) > 0;
            boolean isVariadic = Integer.parseInt(parts[6]) > 0;
            boolean isUnionType = Integer.parseInt(parts[7]) > 0;
            int modifier = Integer.parseInt(parts[8]);
            boolean isIntersectionType = Integer.parseInt(parts[9]) > 0;
            String defValue = parts.length > 3 ? parts[3] : null;
            String declaredType = parts.length > 10 ? parts[10] : null;
            String phpdocType = parts.length > 11 ? parts[11] : null;
            retval = paramName;
        }
        return retval;
    }
    
    public QueryCache<String, Collection<PhpIndexResult>> getQueryCache(){
        return cache;
    }

}
