package com.aplus.gaming.web.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 方便创建容器对象的工具。
 *
 * @author renhui
 */
public final class CollectionUtil {
    /** 创建一个<code>ArrayList</code>。 */
    public static <T> ArrayList<T> createArrayList() {
        return new ArrayList<T>();
    }

    /** 创建一个<code>ArrayList</code>。 */
    public static <T> ArrayList<T> createArrayList(int initialCapacity) {
        return new ArrayList<T>(initialCapacity);
    }

    /** 创建一个<code>ArrayList</code>。 */
    public static <T> ArrayList<T> createArrayList(Iterable<? extends T> c) {
        ArrayList<T> list;

        if (c instanceof Collection<?>) {
            list = new ArrayList<T>((Collection<? extends T>) c);
        } else {
            list = new ArrayList<T>();

            iterableToCollection(c, list);

            list.trimToSize();
        }

        return list;
    }

    /** 创建一个<code>ArrayList</code>。 */
    public static <T, V extends T> ArrayList<T> createArrayList(V... args) {
        if (args == null || args.length == 0) {
            return new ArrayList<T>();
        } else {
            ArrayList<T> list = new ArrayList<T>(args.length);

            for (V v : args) {
                list.add(v);
            }

            return list;
        }
    }

    /** 创建一个<code>LinkedList</code>。 */
    public static <T> LinkedList<T> createLinkedList() {
        return new LinkedList<T>();
    }

    /** 创建一个<code>LinkedList</code>。 */
    public static <T> LinkedList<T> createLinkedList(Iterable<? extends T> c) {
        LinkedList<T> list = new LinkedList<T>();

        iterableToCollection(c, list);

        return list;
    }

    /** 创建一个<code>LinkedList</code>。 */
    public static <T, V extends T> LinkedList<T> createLinkedList(V... args) {
        LinkedList<T> list = new LinkedList<T>();

        if (args != null) {
            for (V v : args) {
                list.add(v);
            }
        }

        return list;
    }

    /**
     * 创建一个<code>List</code>。
     * <p>
     * 和{@code createArrayList(args)}不同，本方法会返回一个不可变长度的列表，且性能高于
     * {@code createArrayList(args)}。
     * </p>
     */
    public static <T> List<T> asList(T... args) {
        if (args == null || args.length == 0) {
            return Collections.emptyList();
        } else {
            return Arrays.asList(args);
        }
    }

    /** 创建一个<code>HashMap</code>。 */
    public static <K, V> HashMap<K, V> createHashMap() {
        return new HashMap<K, V>();
    }

    /** 创建一个<code>HashMap</code>。 */
    public static <K, V> HashMap<K, V> createHashMap(int initialCapacity) {
        return new HashMap<K, V>(initialCapacity);
    }

    /** 创建一个<code>LinkedHashMap</code>。 */
    public static <K, V> LinkedHashMap<K, V> createLinkedHashMap() {
        return new LinkedHashMap<K, V>();
    }

    /** 创建一个<code>LinkedHashMap</code>。 */
    public static <K, V> LinkedHashMap<K, V> createLinkedHashMap(int initialCapacity) {
        return new LinkedHashMap<K, V>(initialCapacity);
    }

    /** 创建一个<code>TreeMap</code>。 */
    public static <K, V> TreeMap<K, V> createTreeMap() {
        return new TreeMap<K, V>();
    }

    /** 创建一个<code>TreeMap</code>。 */
    public static <K, V> TreeMap<K, V> createTreeMap(Comparator<? super K> comparator) {
        return new TreeMap<K, V>(comparator);
    }

    /** 创建一个<code>ConcurrentHashMap</code>。 */
    public static <K, V> ConcurrentHashMap<K, V> createConcurrentHashMap() {
        return new ConcurrentHashMap<K, V>();
    }

    /** 创建一个<code>HashSet</code>。 */
    public static <T> HashSet<T> createHashSet() {
        return new HashSet<T>();
    }

    /** 创建一个<code>HashSet</code>。 */
    public static <T, V extends T> HashSet<T> createHashSet(V... args) {
        if (args == null || args.length == 0) {
            return new HashSet<T>();
        } else {
            HashSet<T> set = new HashSet<T>(args.length);

            for (V v : args) {
                set.add(v);
            }

            return set;
        }
    }

    /** 创建一个<code>HashSet</code>。 */
    public static <T> HashSet<T> createHashSet(Iterable<? extends T> c) {
        HashSet<T> set;

        if (c instanceof Collection<?>) {
            set = new HashSet<T>((Collection<? extends T>) c);
        } else {
            set = new HashSet<T>();
            iterableToCollection(c, set);
        }

        return set;
    }

    /** 创建一个<code>LinkedHashSet</code>。 */
    public static <T> LinkedHashSet<T> createLinkedHashSet() {
        return new LinkedHashSet<T>();
    }

    /** 创建一个<code>LinkedHashSet</code>。 */
    public static <T, V extends T> LinkedHashSet<T> createLinkedHashSet(V... args) {
        if (args == null || args.length == 0) {
            return new LinkedHashSet<T>();
        } else {
            LinkedHashSet<T> set = new LinkedHashSet<T>(args.length);

            for (V v : args) {
                set.add(v);
            }

            return set;
        }
    }

    /** 创建一个<code>LinkedHashSet</code>。 */
    public static <T> LinkedHashSet<T> createLinkedHashSet(Iterable<? extends T> c) {
        LinkedHashSet<T> set;

        if (c instanceof Collection<?>) {
            set = new LinkedHashSet<T>((Collection<? extends T>) c);
        } else {
            set = new LinkedHashSet<T>();
            iterableToCollection(c, set);
        }

        return set;
    }

    /** 创建一个<code>TreeSet</code>。 */
    public static <T> TreeSet<T> createTreeSet() {
        return new TreeSet<T>();
    }

    /** 创建一个<code>TreeSet</code>。 */
    @SuppressWarnings("unchecked")
    public static <T, V extends T> TreeSet<T> createTreeSet(V... args) {
        return (TreeSet<T>) createTreeSet(null, args);
    }

    /** 创建一个<code>TreeSet</code>。 */
    public static <T> TreeSet<T> createTreeSet(Iterable<? extends T> c) {
        return createTreeSet(null, c);
    }

    /** 创建一个<code>TreeSet</code>。 */
    public static <T> TreeSet<T> createTreeSet(Comparator<? super T> comparator) {
        return new TreeSet<T>(comparator);
    }

    /** 创建一个<code>TreeSet</code>。 */
    public static <T, V extends T> TreeSet<T> createTreeSet(Comparator<? super T> comparator, V... args) {
        TreeSet<T> set = new TreeSet<T>(comparator);

        if (args != null) {
            for (V v : args) {
                set.add(v);
            }
        }

        return set;
    }

    /** 创建一个<code>TreeSet</code>。 */
    public static <T> TreeSet<T> createTreeSet(Comparator<? super T> comparator, Iterable<? extends T> c) {
        TreeSet<T> set = new TreeSet<T>(comparator);

        iterableToCollection(c, set);

        return set;
    }


    private static <T> void iterableToCollection(Iterable<? extends T> c, Collection<T> list) {
        for (T element : c) {
            list.add(element);
        }
    }
    /**
	 * Return <code>true</code> if the supplied Collection is <code>null</code>
	 * or empty. Otherwise, return <code>false</code>.
	 * @param collection the Collection to check
	 * @return whether the given Collection is empty
	 */
	public static boolean isEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}
	
	/**
	 * Return <code>true</code> if the supplied Map is <code>null</code>
	 * or empty. Otherwise, return <code>false</code>.
	 * @param map the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isEmpty(Map map) {
		return (map == null || map.isEmpty());
	}

	public static String[] toNoNullStringArray(Collection collection) {
        if (collection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return toNoNullStringArray(collection.toArray());
    }
	
	static String[] toNoNullStringArray(Object[] array) {
        ArrayList list = new ArrayList(array.length);
        for (int i = 0; i < array.length; i++) {
            Object e = array[i];
            if (e != null) {
                list.add(e.toString());
            }
        }
        return (String[]) list.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    /**
     * 分批list
     * @author zhangyong
     * @param sourceList
     *            要分批的list
     * @param batchCount
     *            每批list的个数
     * @return List<List<Object>>
     */
    public static <T>List<List<T>> batchList(List<T> sourceList, int batchCount) {
        List<List<T>> returnList = new ArrayList<>();
        //提升效率
        if (sourceList.size() <= batchCount){
            returnList.add(sourceList);
            return returnList;
        }
        int startIndex = 0; // 从第0个下标开始
        while (startIndex < sourceList.size()) {
            int endIndex = 0;
            if (sourceList.size() - batchCount < startIndex) {
                endIndex = sourceList.size();
            } else {
                endIndex = startIndex + batchCount;
            }
            returnList.add(sourceList.subList(startIndex, endIndex));
            startIndex = startIndex + batchCount; // 下一批
        }
        return returnList;
    }
}
