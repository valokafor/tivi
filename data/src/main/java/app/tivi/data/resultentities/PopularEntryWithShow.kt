/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.data.resultentities

import androidx.room.Embedded
import androidx.room.Relation
import app.tivi.data.entities.PopularShowEntry
import app.tivi.data.entities.ShowTmdbImage
import app.tivi.data.entities.TiviShow
import java.util.Objects

class PopularEntryWithShow : EntryWithShow<PopularShowEntry> {
    @Embedded
    override lateinit var entry: PopularShowEntry

    @Relation(parentColumn = "show_id", entityColumn = "id")
    override var relations: List<TiviShow> = emptyList()

    @Relation(parentColumn = "show_id", entityColumn = "show_id")
    override var images: List<ShowTmdbImage> = emptyList()

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is PopularEntryWithShow -> {
            entry == other.entry && relations == other.relations && images == other.images
        }
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations, images)
}
