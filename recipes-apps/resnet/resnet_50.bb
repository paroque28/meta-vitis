DESCRIPTION = "This package contains Resnet50 program for DPU."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"


SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;branch=v1.0"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"


do_install() {
  install -d ${D}/opt/Vitis-AI
  cp -r  ${S}/DPU-TRD/app/Vitis/samples/resnet50 ${D}/opt/Vitis-AI

  install -d ${D}${libdir}
  install -m 0655 ${S}/DPU-TRD/app/Vitis/models/libdpumodelresnet50.so ${D}${libdir}
}


FILES_${PN} += "/opt/ /opt/Vitis-AI/ /opt/Vitis-AI/*"

INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev += "dev-elf"

DEPENDS = "dnndk" 
