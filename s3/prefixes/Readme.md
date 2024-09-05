## Create our bucket
```sh
aws s3 mb s3://prefixes-fun-nmce-1234
```

## Create our folder
```sh
aws s3api put-object --bucket="prefixes-fun-nmce-1234" --key="hello/"
```

## Create many folders
```sh
aws s3api put-object --bucket="prefixes-fun-nmce-1234" --key="Lorem/ipsum/dolor/sit/amet/consectetur/adipiscing/elit/Sed/imperdiet/eros/eget/neque/tincidunt/et/congue/massa/tempor/Pellentesque/habitant/morbi/tristique/senectus/et/netus/et/malesuada/fames/ac/turpis/egestas/Aliquam/ante/lorem/elementum/a/imperdiet/in/vulputate/quis/tellus/Aliquam/sit/amet/purus/ultricies/dignissim/velit/nec/euismod/magna/Integer/condimentum/eros/sed/elementum/dignissim/sem/dui/porttitor/nibh/eu/pharetra/eros/sem/eget/eros/Integer/nisl/nibh/egestas/et/interdum/sit/amet/posuere/ut/neque/Ut/dignissim/interdum/sollicitudin/Ut/eu/vulputate/leo/Quisque/pharetra/dictum/enim/sed/commodo/purus/aliquam/ac/Donec/dapibus/risus/nec/consectetur/malesuada/arcu/purus/condimentum/erat/sed/sollicitudin/eros/elit/nec/tellus/Phasellus/vitae/dignissim/nisi/eget/semper/arcu/Quisque/id/erat/diam/Morbi/ullamcorper/dui/a/lacus/rutrum/lacinia/Donec/vulputate/diam/nec/massa/tempus/rutrum/Sed/ac/tincidunt/arcu/et/fringilla/nisl/In/efficitur/libero/at/convallis/cursus/nisi/nibh/biam/drf/dsg/fdg/erwq/sada/adasda/asdef"
```

## Try and break the 1024 limit
```sh
aws s3api put-object --bucket="prefixes-fun-nmce-1234" --key="Lorem/ipsum/dolor/sit/amet/consectetur/adipiscing/elit/Sed/imperdiet/eros/eget/neque/tincidunt/et/congue/massa/tempor/Pellentesque/habitant/morbi/tristique/senectus/et/netus/et/malesuada/fames/ac/turpis/egestas/Aliquam/ante/lorem/elementum/a/imperdiet/in/vulputate/quis/tellus/Aliquam/sit/amet/purus/ultricies/dignissim/velit/nec/euismod/magna/Integer/condimentum/eros/sed/elementum/dignissim/sem/dui/porttitor/nibh/eu/pharetra/eros/sem/eget/eros/Integer/nisl/nibh/egestas/et/interdum/sit/amet/posuere/ut/neque/Ut/dignissim/interdum/sollicitudin/Ut/eu/vulputate/leo/Quisque/pharetra/dictum/enim/sed/commodo/purus/aliquam/ac/Donec/dapibus/risus/nec/consectetur/malesuada/arcu/purus/condimentum/erat/sed/sollicitudin/eros/elit/nec/tellus/Phasellus/vitae/dignissim/nisi/eget/semper/arcu/Quisque/id/erat/diam/Morbi/ullamcorper/dui/a/lacus/rutrum/lacinia/Donec/vulputate/diam/nec/massa/tempus/rutrum/Sed/ac/tincidunt/arcu/et/fringilla/nisl/In/efficitur/libero/at/convallis/cursus/nisi/nibh/biam/drf/dsg/fdg/erwq/sada/adasda/asdef/nisl/hello.txt" --body="hello.txt"
```