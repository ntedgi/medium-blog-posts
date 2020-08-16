//package com.b8.ai.playground
//
//import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
//import java.io.File
//
//fun main() {
//    val counter = Object2IntOpenHashMap<String>()
//
//    File("/home/naort/Desktop/hashtags.tsv.csv").bufferedReader().useLines {
//        val charsToRemove = listOf("'", "[", "]", "\"", "#")
//        it.filter { it.isNotEmpty() }.forEach {
//            it.split(",", " ").filter { it.length > 4 && !it.contains(":") }.forEach {
//                var cp = it
//                charsToRemove.forEach {
//                    cp = cp.replace(it, "")
//                }
//                counter.addTo(cp.trim(), 1)
//            }
//        }
//    }
//    val output = "/home/naort/projects/cognitive-search/cs-services/cs-clients/src/main/kotlin/com/b8/ai/playground"
//    File("$output/frequency.csv").bufferedWriter().use { writer ->
//        writer.appendln("frequency,hashtag")
//        counter.toMap().entries.sortedByDescending { it.value }.forEach { (t, u) ->
//            writer.appendln("$u,$t")
//            println("$u     $t")
//        }
//    }
//    File("$output/groupBy.csv").bufferedWriter().use { writer ->
//        writer.appendln("lowerCaseHashTag,hashtags")
//        val map = counter.toMap().entries.groupBy {
//            it.key.toLowerCase()
//        }.entries.sortedByDescending { it.value.sumBy { it.value } }.map { it.key to it.value.map { it.key } }
//            .forEach {
//                writer.appendln(
//                    "${it.first},${it.second}"
//                )
//                println("${it.first} ${it.second}")
//            }
//
//
//    }
//}
