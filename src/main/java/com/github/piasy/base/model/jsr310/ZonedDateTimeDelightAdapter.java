package com.github.piasy.base.model.jsr310;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.squareup.sqldelight.ColumnAdapter;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class ZonedDateTimeDelightAdapter implements ColumnAdapter<ZonedDateTime> {

    private final DateTimeFormatter mDateTimeFormatter;

    public ZonedDateTimeDelightAdapter(final DateTimeFormatter dateTimeFormatter) {
        mDateTimeFormatter = dateTimeFormatter;
    }

    @NonNull
    @Override
    public ZonedDateTime map(final Cursor cursor, final int columnIndex) {
        return mDateTimeFormatter.parse(cursor.getString(columnIndex), ZonedDateTime.FROM);
    }

    @Override
    public void marshal(final ContentValues values, final String key,
            @NonNull final ZonedDateTime value) {
        values.put(key, mDateTimeFormatter.format(value));
    }
}
