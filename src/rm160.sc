;;; Sierra Script 1.0 - (do not remove this comment)
(script# 160)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use PolyPath)
(use Polygon)
(use CueObj)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm160 0
)

(local
	theGLl5DoVerbCode
	local1
	local2
	local3
	local4
)
(instance rm160 of LLRoom
	(properties
		lookStr {Kdysi se PornProdCorp v˝raznÏ podÌlela na filmech s hodnocenÌm X, ale od ned·vnÈho I.P.O. a vstupu do soft-R televize zcela zmÏnila svou imidû. NynÌ se snaûÌ prorazit si cestu k seriÛznosti.}
		picture 160
		north 180
		east 190
		west 170
	)
	
	(method (init)
		(self setRegions: 40)
		(gLarry init: normalize: illegalBits: -32760)
		(switch gGNumber
			(140
				(proc0_3)
				(gLongSong number: 160 setLoop: -1 play:)
				(= style 7)
				(gLarry posn: 138 121 setHeading: 180 edgeHit: 0)
				(gIconBar disable: 8)
			)
			(155
				(proc0_7 7)
				(= global107 160)
				(proc0_13 0)
				(gLarry get: 0)
				(= global15 2)
				(if (proc0_6 80) (= global15 (+ global15 1)))
				(if (proc0_6 81) (= global15 (+ global15 1)))
				(gLongSong number: 160 setLoop: -1 play:)
				(proc0_3)
			)
			(west
				(self setScript: sFromWest)
			)
			(north
				(proc0_3)
				(gLarry
					posn: 260 77
					setHeading: 180
					edgeHit: 0
					illegalBits: 0
				)
			)
			(east (gLarry y: 160))
			(else 
				(if (!= gGNumber 150)
					(proc0_7 7)
					(= global15 2)
					(if (proc0_6 80) (= global15 (+ global15 1)))
					(if (proc0_6 81) (= global15 (+ global15 1)))
					(gLarry get: 0)
				)
				(gLarry
					posn: (presDoor approachX?) (presDoor approachY?)
					edgeHit: 0
				)
				(gLongSong number: 160 setLoop: -1 play:)
				(proc0_3)
			)
		)
		(super init:)
		(fileDoor init: approachVerbs: 3)
		(presDoor init: approachVerbs: 3)
		(if (not (proc0_6 7))
			(coffee init: approachVerbs: 3 setScript: sCoffee)
		)
		(coffeeMaker init:)
		(leftDoor init: approachVerbs: 3)
		(bigSign init:)
		(portrait init: approachVerbs: 3 2)
		(poster init: approachVerbs: 3 2)
		(pictures init: approachVerbs: 3 2)
		(onePicture init: approachVerbs: 3 2)
		(certificate init: approachVerbs: 3 2)
		(plant init: approachVerbs: 3)
		(smallPlant init: approachVerbs: 3)
		(largePlant init: approachVerbs: 3)
		(bronzeAward init: approachVerbs: 3 2)
		(waterCooler init: approachVerbs: 3)
		(chair init:)
		(desk init: approachVerbs: 3)
		(cabinetDoors init: approachVerbs: 3 2)
		(outlet init: approachVerbs: 3 4)
		(hallway init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						79
						296
						79
						286
						71
						273
						71
						273
						44
						250
						44
						250
						71
						233
						71
						219
						86
						143
						86
						137
						74
						118
						74
						104
						59
						0
						59
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						0
						73
						79
						73
						99
						76
						98
						92
						66
						108
						54
						113
						12
						113
						11
						119
						60
						119
						48
						131
						22
						135
						2
						148
						2
						187
						185
						187
						190
						181
						216
						181
						220
						187
						314
						187
						319
						157
						319
						189
						0
						189
					yourself:
				)
		)
		(if (not (proc0_6 7)) (helpTimer set: helpTimer 45))
		(= theGLl5DoVerbCode gLl5DoVerbCode)
		(= gLl5DoVerbCode doVerb160Code)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gLarry 2)
				(if (not (proc0_6 7))
					(self setScript: sMoveOffControl 0 10)
				else
					(self newRoom: west)
				)
			)
			((and (proc0_5 gLarry 4) (not (proc0_6 7))) (self setScript: sMoveOffControl 0 -10))
			(
				(and
					(not local4)
					(== (gLarry loop?) 3)
					(< 30 (gLarry distanceTo: waterCooler))
					(< (gLarry distanceTo: waterCooler) 40)
				)
				(self setScript: sBelch)
			)
			(
			(and local4 (> (gLarry distanceTo: waterCooler) 60)) (= local4 0))
		)
	)
	
	(method (dispose)
		(helpTimer dispose: delete:)
		(coffeeTimer dispose: delete:)
		(= gLl5DoVerbCode theGLl5DoVerbCode)
		(super dispose:)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 190) (gLongSong fade: 80 25 10 0))
		(super newRoom: newRoomNumber)
	)
)

(instance sMoveOffControl of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					setMotion: MoveTo (+ (gLarry x?) register) (gLarry y?) self
				)
			)
			(1
				(proc0_14 160 0)
				(self dispose:)
			)
		)
	)
)

(instance sCoffee of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(coffeeTimer cycleCnt: 0)
				(coffeeYell
					init:
					setCel: 0
					posn: (coffeeYell x?) (Random 53 104)
					cycleSpeed: (Random 5 10)
					setCycle: End self
				)
			)
			(1
				(coffeeSound setLoop: 0 play:)
				(coffeeYell setCycle: CT 3 -1 self)
			)
			(2
				(coffeeYell setCycle: End)
				(= ticks (Random 30 90))
			)
			(3
				(coffeeYell dispose:)
				(coffeeTimer setReal: coffeeTimer (Random 6 12))
				(self dispose:)
			)
		)
	)
)

(instance sFromWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry posn: 65 70 setMotion: MoveTo 95 70 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sBelch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(waterSound setLoop: 0 play:)
				(waterCooler setLoop: 4 setCycle: End self)
			)
			(1
				(waterCooler setLoop: 3 setCel: 0)
				(gLarry
					view: 160
					loop: 5
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(proc0_18 gLarry 160 1 67 -1 185)
				(gLarry setLoop: 3 normalize: illegalBits: -32760)
				(proc0_3)
				(= local4 1)
				(self dispose:)
			)
		)
	)
)

(instance sDeliver of Script
	(properties)
	
	(method (changeState newState &tmp presDoorApproachX presDoorApproachY)
		(switch (= state newState)
			(0
				(proc0_2)
				(coffeeTimer dispose: delete:)
				(helpTimer dispose: delete:)
				(gLarry view: 141 setLoop: 0 setCycle: CT 1 1 self)
			)
			(1
				(coffee dispose:)
				(gLarry setCycle: End self)
			)
			(2
				(coffee dispose:)
				(if (gCast contains: coffeeYell) (coffeeYell dispose:))
				(proc0_10 1 82)
				(proc0_14 160 2)
				(= presDoorApproachX (presDoor approachX?))
				(= presDoorApproachY (presDoor approachY?))
				(gLarry
					normalize: 141
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath presDoorApproachX presDoorApproachY self
				)
			)
			(3
				(presDoor entranceTo: 140 doVerb: 3)
			)
		)
	)
)

(instance fileDoor of Door
	(properties
		x 245
		y 67
		description {dve¯e spisovny}
		approachX 264
		approachY 76
		view 160
		loop 2
		entranceTo 180
		moveToX 264
		moveToY 61
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 160 3)
				(= local1 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (open)
		(if (not (proc0_6 7))
			(proc0_14 160 0)
			(= local2 1)
		else
			(gLarry illegalBits: 0)
			(super open: &rest)
		)
	)
	
	(method (close)
		(gLarry illegalBits: -32760)
		(super close:)
	)
)

(instance presDoor of Door
	(properties
		x 47
		y 110
		heading 90
		description {dve¯e kancel·¯e Silase Scruemalla}
		approachX 60
		approachY 116
		view 160
		loop 1
		entranceTo 155
		moveToX 27
		moveToY 115
		enterType 1
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (proc0_6 7)
					(proc0_14 160 4)
				else
					(super doVerb: theVerb param2 &rest)
				)
				(= local2 1)
			)
			(2
				(proc0_14 160 5)
				(proc0_14 160 6)
				(= local1 1)
			)
			(5
				(proc0_18 gLarry 160 7)
				(proc0_14 160 8 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (open)
		(if
		(and (gCast contains: coffee) (not (proc0_6 7)))
			(coffee setScript: sCoffee)
		else
			(super open: &rest)
		)
	)
)

(instance coffee of Prop
	(properties
		x 73
		y 75
		description {konvice na k·vu}
		approachX 98
		approachY 97
		view 160
		priority 6
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 160 9)
				(= local3 1)
				(= local1 1)
			)
			(3
				(global2 setScript: sDeliver)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance coffeeYell of Prop
	(properties
		x 32
		y 81
		description {zvuk pij·k˘ k·vy}
		lookStr {Vypad· to, ûe nÏkdo chce k·vu!}
		view 162
		priority 14
		signal $4010
	)
)

(instance coffeeSound of Sound
	(properties
		number 161
	)
)

(instance waterCooler of Prop
	(properties
		x 204
		y 182
		description {sodomat}
		approachX 201
		approachY 179
		lookStr {Sodomat je vybavenÌ kancel·¯e, kterÈ zn·ö nejlÈpe.}
		view 160
		loop 3
		priority 15
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(waterSound play:)
				(self setCycle: End self)
				(= local2 1)
				(proc0_14 160 10)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(waterCooler setCel: 0)
		(proc0_10 1 80)
	)
)

(instance waterSound of Sound
	(properties
		number 163
	)
)

(instance helpTimer of Timer
	(properties)
	
	(method (cue)
		(cond 
			((not local1)
				(proc0_14 160 11)
				(proc0_14 160 12)
				(proc0_14 160 13)
				(proc0_14 160 14)
				(self set: self 45)
			)
			(
			(and (== 95 (gLarry x?)) (== 65 (gLarry y?))) (proc0_14 160 15) (proc0_14 160 16) (self set: self 45))
			((not local2) (proc0_14 160 17) (self set: self 45))
			((not local3) (proc0_14 160 18) (self set: self 45))
			(else (proc0_14 160 19) (proc0_14 160 20))
		)
	)
)

(instance coffeeTimer of Timer
	(properties)
	
	(method (cue)
		(coffee setScript: sCoffee)
	)
)

(instance coffeeMaker of Feature
	(properties
		x 72
		y 69
		nsTop 61
		nsLeft 62
		nsBottom 78
		nsRight 82
		description {k·vovar}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (gCast contains: coffee)
					(proc0_14 160 21)
				else
					(proc0_14 160 22)
				)
			)
			(3 (proc0_14 160 23))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance leftDoor of Feature
	(properties
		x 22
		y 87
		nsTop 51
		nsLeft 12
		nsBottom 123
		nsRight 32
		description {Dve¯e kancel·¯e Silase Scruemalla}
		sightAngle 40
		approachX 60
		approachY 116
	)
	
	(method (doVerb)
		(presDoor doVerb: &rest)
	)
)

(instance bigSign of Feature
	(properties
		x 176
		y 26
		nsLeft 153
		nsBottom 52
		nsRight 199
		description {n·pis "NejvÌc sexy dom·cÌ videa Ameriky"}
		sightAngle 40
		lookStr {Z¯ejmÏ je tato spoleËnost domovem "NejvÌc sexy dom·cÌ videa Ameriky". Slyöel jsi o tom po¯adu! Zvl·öù kdyû tu pracujeö!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 24)
				(= local2 1)
			)
			(5 (proc0_14 160 25))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance portrait of Feature
	(properties
		x 62
		y 40
		nsTop 24
		nsLeft 53
		nsBottom 57
		nsRight 71
		description {portrÈt Silase Scruemalla}
		sightAngle 40
		approachX 94
		approachY 95
		lookStr {"N·ö zakladatel, Silas Scruemall!"}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 26)
				(proc0_14 160 27)
				(proc0_14 160 28 67 -1 185)
				(= local2 1)
			)
			(5 (proc0_14 160 29))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance poster of Feature
	(properties
		x 93
		y 27
		nsTop 11
		nsLeft 83
		nsBottom 43
		nsRight 103
		description {plak·t}
		sightAngle 40
		lookStr {UmÏnÌ je jedna vÏc, ale tohle je nÏco jinÈho!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 30)
				(proc0_14 160 31 67 -1 185)
				(= local2 1)
			)
			(5 (proc0_14 160 32))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance pictures of Feature
	(properties
		x 128
		y 29
		nsTop 11
		nsLeft 111
		nsBottom 48
		nsRight 146
		description {fotografie}
		sightAngle 40
		approachX 122
		approachY 75
		lookStr {Na fotografiÌch jsou b˝valÈ hvÏzdy mnoha film˘, televiznÌch po¯ad˘ a umÏleck˝ch dokument˘ spoleËnosti PornProdCorp. Je tu celkem nula fotek hlavnÌch p¯evÌjeË˘ videokazet, jako jsi ty. Nem·ö d˘vod p¯edpokl·dat, ûe budeö prvnÌ!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 33)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance onePicture of Feature
	(properties
		x 220
		y 22
		nsTop 11
		nsLeft 213
		nsBottom 33
		nsRight 228
		description {fotografie hydrantu}
		sightAngle 40
		approachX 231
		approachY 78
		lookStr {Je to buÔ hvÏzda filmu Lovec lidÌ, nebo poû·rnÌ hydrant, nevÌö, co z toho.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 34)
				(= local2 1)
			)
			(5 (proc0_14 160 35))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance certificate of Feature
	(properties
		x 295
		y 24
		nsTop 15
		nsLeft 295
		nsBottom 29
		nsRight 309
		description {certifik·t}
		sightAngle 40
		approachX 288
		approachY 76
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 160 36 30 1))
			(3
				(proc0_14 160 37)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 305
		y 45
		nsTop 31
		nsLeft 292
		nsBottom 60
		nsRight 319
		description {rostlina}
		sightAngle 40
		approachX 291
		approachY 75
		lookStr {Na pohled se ti opravdu lÌbÌ jemn˝ plast.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 38)
				(= local2 1)
			)
			(5 (proc0_14 160 39))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance smallPlant of Feature
	(properties
		x 13
		y 188
		nsTop 139
		nsBottom 183
		nsRight 26
		description {rostlina}
		sightAngle 40
		approachX 16
		approachY 187
		lookStr {Opravdu si uûÌv·ö vzhled jemnÈho plastu.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 40)
				(= local2 1)
			)
			(5 (proc0_14 160 39))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance largePlant of Feature
	(properties
		x 245
		y 180
		nsTop 112
		nsLeft 224
		nsBottom 182
		nsRight 266
		description {rostlina}
		sightAngle 40
		approachX 260
		approachY 179
		lookStr {Jak jen milujeö plastovÈ rostliny! (HlavnÏ tu v˘ni!)}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 41)
				(= local2 1)
			)
			(5 (proc0_14 160 39))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance bronzeAward of Feature
	(properties
		x 283
		y 186
		nsTop 173
		nsLeft 280
		nsBottom 189
		nsRight 313
		description {OcenÏnÌ "Cecky"}
		sightAngle 40
		approachX 283
		approachY 185
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 160 42 30 1 80 {Prav˝ gravÌrovan˝ plast})
				(proc0_10 1 81)
				(proc0_14 160 43 67 -1 185)
				(= local1 1)
			)
			(3
				(proc0_14 160 44)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 117
		y 173
		nsTop 164
		nsLeft 106
		nsBottom 183
		nsRight 129
		description {ûidle}
		sightAngle 40
		lookStr {Tato ûidle a st˘l pat¯Ì osobÏ, kter· je nejmÈnÏ oblÌben· u tvÈho öÈfa, Silasovi Scruemallovi. V souËasnÈ dobÏ jsou neobsazenÈ. »asto zde sed·v·ö ty.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 45)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 132
		y 186
		nsTop 184
		nsLeft 85
		nsBottom 189
		nsRight 179
		description {st˘l}
		sightAngle 40
		approachX 151
		approachY 188
		lookStr {Tato ûidle a st˘l pat¯Ì osobÏ, kter· m· u tvÈho öÈfa, Silase Scruemalla, nejmenöÌ p¯ÌzeÚ. V souËasnÈ dobÏ jsou neobsazenÈ. »asto zde sed·v·ö ty.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 46)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cabinetDoors of Feature
	(properties
		x 78
		y 92
		nsTop 86
		nsLeft 70
		nsBottom 99
		nsRight 87
		description {sk¯ÌÚka}
		sightAngle 40
		lookStr {Ve sk¯ÌÚce pod konvicÌ na k·vu je jen krabice s promyölenÏ p¯edem odmÏ¯en˝mi, p¯edem zeslaben˝mi porcemi k·vy a nÏkolik pr·zdn˝ch plastov˝ch s·Ëk˘, ve kter˝ch b˝valy hrom·dky polystyrenov˝ch kelÌmk˘ na k·vu. Nepot¯ebujeö ani k·vu, ani filtry.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 160 47)
				(= local2 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 51
		y 97
		nsTop 88
		nsLeft 48
		nsBottom 101
		nsRight 55
		description {elektrick· z·suvka}
		sightAngle 40
		approachX 77
		approachY 105
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (== ((Inv at: 1) owner?) global2)
					(proc0_14 160 48)
				else
					(proc0_14 160 49)
				)
				(= local1 1)
			)
			(3
				(if (not (== ((Inv at: 1) owner?) global2))
					(global2 setScript: (ScriptID 22 2) 0 1)
				else
					((ScriptID 22 3) doVerb: 3)
				)
				(= local2 1)
			)
			(4
				(switch param2
					(1
						(proc0_14 160 50)
						(global2 setScript: (ScriptID 22 0))
					)
					(0 (proc0_14 160 51))
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance hallway of Feature
	(properties
		x 99
		y 64
		nsTop 57
		nsLeft 77
		nsBottom 71
		nsRight 122
		description {p¯edsÌÚ}
		sightAngle 40
		lookStr {Tato chodba vede do oddÏlenÌ p¯evÌjenÌ videokazet a do tvÈ pracovny, kde vykon·v·ö svou pr·ci hlavnÌho p¯evÌjeËe a steriliz·tora (divize Betamax).}
	)
)

(instance doVerb160Code of Code
	(properties)
	
	(method (doit param1 param2 &tmp temp0 temp1 [temp2 100])
		(= temp0 (param2 description?))
		(switch param1
			(2
				(if (param2 facingMe: gLarry)
					(if (param2 lookStr?)
						(proc0_14 (param2 lookStr?))
					else
						(proc0_12 param2 param1)
					)
				)
				(= local1 1)
			)
			(5
				(if (param2 facingMe: gLarry)
					(Format @temp2 160 52 temp0)
					(proc0_14 @temp2)
				)
			)
			(3
				(Format @temp2 160 53 temp0)
				(proc0_14 @temp2)
				(= local2 1)
			)
			(4
				(= temp1 ((gIconBar curInvIcon?) description?))
				(Format @temp2 160 54 temp1 temp0)
				(proc0_14 @temp2)
			)
			(10
				(Format @temp2 160 55 temp0)
				(proc0_14 @temp2)
			)
			(else  (proc0_12 param2 param1))
		)
	)
)
