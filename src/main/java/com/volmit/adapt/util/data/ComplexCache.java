/*
 *  Copyright (c) 2016-2025 Arcane Arts (Volmit Software)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *
 */

package com.volmit.adapt.util.data;

//import com.volmit.react.util.cache.Cache;
//import com.volmit.react.util.collection.KMap;

import com.volmit.adapt.util.cache.Cache;
import com.volmit.adapt.util.collection.KMap;

public class ComplexCache<T> {
    private final KMap<Long, ChunkCache<T>> chunks;

    public ComplexCache() {
        chunks = new KMap<>();
    }

    public boolean has(int x, int z) {
        return chunks.containsKey(Cache.key(x, z));
    }

    public void invalidate(int x, int z) {
        chunks.remove(Cache.key(x, z));
    }

    public ChunkCache<T> chunk(int x, int z) {
        return chunks.computeIfAbsent(Cache.key(x, z), (f) -> new ChunkCache<>());
    }
}
