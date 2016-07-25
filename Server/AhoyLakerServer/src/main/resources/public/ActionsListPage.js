$.ajax("/actions/top").done(function(data) {
    if(data) {
        $('#title').html(data[0].name);
        $('#id').html(data[0].id);
        $('#name').html(data[0].name);
        $('#is-link').html(data[0].link);
        $('#url').html(data[0].url);
        $('#parent-id').html(data[0].parentID);
    }
});